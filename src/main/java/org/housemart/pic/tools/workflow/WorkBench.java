/**
 * Created on 2013-4-21
 * 
 */
package org.housemart.pic.tools.workflow;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.housemart.pic.model.anjuke.CommunityGet;
import org.housemart.pic.model.anjuke.CommunityProp;
import org.housemart.pic.model.anjuke.ModelPhotos;
import org.housemart.pic.model.anjuke.Property;
import org.housemart.pic.model.anjuke.RoomPhotos;
import org.housemart.pic.model.hm.HouseEntity;
import org.housemart.pic.model.hm.HousePicEntity;
import org.housemart.pic.model.hm.HousePicEntity.CrawlStatus;
import org.housemart.pic.model.hm.ResidenceEntity;
import org.housemart.pic.service.HousePicService;
import org.housemart.pic.service.HouseService;
import org.housemart.pic.service.ResidenceService;
import org.housemart.pic.service.crawl.impl.anjuke.AnJuKeCrawlConstants;
import org.housemart.pic.service.crawl.impl.anjuke.search.CommunitySearcher;
import org.housemart.pic.service.crawl.impl.anjuke.search.HouseListSearcher;
import org.housemart.pic.service.crawl.impl.anjuke.store.data.DataConverter;
import org.housemart.pic.service.crawl.impl.anjuke.store.file.PicCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.webharvest.runtime.Scraper;

public class WorkBench {

	Log log = LogFactory.getLog(this.getClass());

	@Autowired
	ResidenceService residenceService;
	@Autowired
	HouseService houseService;
	@Autowired
	HousePicService housePicService;
	@Autowired
	HouseListSearcher houseListSearcher;
	@Autowired
	CommunitySearcher communitySearcher;
	@Autowired
	PicCrawler picCrawler;

	public void runByRegionId(int regionId) {
		List<ResidenceEntity> residencesToCrawl = residenceService.selectResidence(regionId);
		run(residencesToCrawl);
	}

	public void runByAdminRegionId(int adminRegionId) {
		List<ResidenceEntity> residencesToCrawl = residenceService.selectResidenceByAdminRegion(adminRegionId);
		run(residencesToCrawl);
	}

	private void run(List<ResidenceEntity> residencesToCrawl) {

		for (ResidenceEntity residence : residencesToCrawl) {
			String pathPrefix = residence.getRegionName() + "/" + residence.getPlateName() + "/"
					+ residence.getResidenceName();

			try {

				List<Property> properties = houseListSearcher.search(AnJuKeCrawlConstants.CITY_SHANGHAI, residence
						.getResidenceName().trim());
				if (CollectionUtils.isNotEmpty(properties)) {
					Property firstProperty = properties.get(0);

					// residence
					String anjukeCommunityId = firstProperty.getCommunity().getId();
					CommunityGet communityGet = communitySearcher.search(anjukeCommunityId);

					// pic of residence
					List<String> photosOfResidence = communityGet.getPhotos();
					if (CollectionUtils.isNotEmpty(photosOfResidence)) {
						for (String photo : photosOfResidence) {
							String url = photo;
							String subPath = pathPrefix + WorkBenchConstants.FILE_SUBPATH_RESIDENCE;
							String storePath = subPath + "/"
									+ StringUtils.substringAfterLast(url, "com/").replaceAll("/", "-");
							// file
							picCrawler.crawl(url, storePath);

							// db
							HousePicEntity.CrawlStatus crawlStatus = CrawlStatus.Error;
							if (picCrawler.getScraper().getStatus() == Scraper.STATUS_FINISHED)
								crawlStatus = CrawlStatus.Success;
							addHousePic(null, residence.getResidenceId(), storePath, HousePicEntity.Type.RoomType,
									crawlStatus);
						}
					}

					// house
					for (Property property : properties) {

						CommunityProp commProp = property.getCommunity();
						commProp.setId(String.valueOf(residence.getResidenceId()));
						property.setCommunity(commProp);

						HouseEntity house = DataConverter.convertPropertyToHouseEntity(property);
						int houseId = houseService.addHouse(house);

						// pic of room
						List<ModelPhotos> photosOfHouse = property.getModel_photos();
						if (CollectionUtils.isNotEmpty(photosOfHouse)) {
							for (ModelPhotos photo : photosOfHouse) {
								String url = photo.getUrl();
								String subPath = pathPrefix + WorkBenchConstants.FILE_SUBPATH_ROOM;
								String storePath = subPath + "/"
										+ StringUtils.substringAfterLast(url, "com/").replaceAll("/", "-");
								// file
								picCrawler.crawl(url, storePath);
								// db
								HousePicEntity.CrawlStatus crawlStatus = CrawlStatus.Error;
								if (picCrawler.getScraper().getStatus() == Scraper.STATUS_FINISHED)
									crawlStatus = CrawlStatus.Success;
								addHousePic(houseId, residence.getResidenceId(), storePath,
										HousePicEntity.Type.RoomType, crawlStatus);
							}
						}

						// pic of house
						List<RoomPhotos> photosOfRoom = property.getRoom_photos();
						if (CollectionUtils.isNotEmpty(photosOfRoom)) {
							for (RoomPhotos photo : photosOfRoom) {
								String url = photo.getUrl();
								String subPath = pathPrefix + WorkBenchConstants.FILE_SUBPATH_HOUSE;
								String storePath = subPath + "/"
										+ StringUtils.substringAfterLast(url, "com/").replaceAll("/", "-");
								// file
								picCrawler.crawl(url, storePath);
								// db
								HousePicEntity.CrawlStatus crawlStatus = CrawlStatus.Error;
								if (picCrawler.getScraper().getStatus() == Scraper.STATUS_FINISHED)
									crawlStatus = CrawlStatus.Success;
								addHousePic(houseId, residence.getResidenceId(), storePath,
										HousePicEntity.Type.HousePic, crawlStatus);
							}
						}

					}

				}

			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	private void addHousePic(Integer houseId, int residenceId, String path, HousePicEntity.Type type,
			HousePicEntity.CrawlStatus crawlStatus) {
		HousePicEntity picEntity = new HousePicEntity();
		picEntity.setHouseId(houseId);
		picEntity.setResidenceId(residenceId);
		picEntity.setType(type.getValue());
		picEntity.setCrawlStatus(crawlStatus.getValue());
		picEntity.setAddTime(Calendar.getInstance().getTime());
		picEntity.setUpdateTime(Calendar.getInstance().getTime());
		picEntity.setUrl(path);
		housePicService.addHousePic(picEntity);
	}
}
