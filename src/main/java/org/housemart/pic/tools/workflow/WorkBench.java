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
import org.housemart.pic.model.hm.ResidenceEntity;
import org.housemart.pic.service.HousePicService;
import org.housemart.pic.service.HouseService;
import org.housemart.pic.service.ResidenceService;
import org.housemart.pic.service.crawl.impl.anjuke.AnJuKeConstants;
import org.housemart.pic.service.crawl.impl.anjuke.search.CommunitySearcher;
import org.housemart.pic.service.crawl.impl.anjuke.search.HouseListSearcher;
import org.housemart.pic.service.crawl.impl.anjuke.store.data.DataConverter;
import org.housemart.pic.service.crawl.impl.anjuke.store.file.PicCrawler;
import org.springframework.beans.factory.annotation.Autowired;

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

	public void run() {
		List<ResidenceEntity> residencesToCrawl = residenceService.selectResidence(393);

		for (ResidenceEntity r : residencesToCrawl) {

			try {

				List<Property> properties = houseListSearcher.search(AnJuKeConstants.CITY_SHANGHAI, r
						.getResidenceName().trim());
				if (CollectionUtils.isNotEmpty(properties)) {
					Property firstProperty = properties.get(0);

					// residence
					String anjukeCommunityId = firstProperty.getCommunity().getId();
					CommunityGet communityGet = communitySearcher.search(anjukeCommunityId);
					CommunityProp commProp = firstProperty.getCommunity();
					commProp.setId(String.valueOf(r.getResidenceId()));
					firstProperty.setCommunity(commProp);

					// pic of residence
					List<String> photosOfResidence = communityGet.getPhotos();
					if (CollectionUtils.isNotEmpty(photosOfResidence)) {
						for (String photo : photosOfResidence) {
							String url = photo;
							String subPath = r.getResidenceName() + "/residence/";
							String storePath = subPath + "/"
									+ StringUtils.substringAfterLast(url, "com/").replaceAll("/", "-");
							// file
							picCrawler.crawl(url, storePath);
							// db
							HousePicEntity picEntity = new HousePicEntity();
							picEntity.setHouseId(null);
							picEntity.setResidenceId(r.getResidenceId());
							picEntity.setType(HousePicEntity.Type.Residence.getValue());
							picEntity.setAddTime(Calendar.getInstance().getTime());
							picEntity.setUpdateTime(Calendar.getInstance().getTime());
							picEntity.setUrl(storePath);
							housePicService.addHousePic(picEntity);
						}
					}

					// house
					for (Property property : properties) {

						HouseEntity house = DataConverter.convertPropertyToHouseEntity(property);
						int houseId = houseService.addHouse(house);

						// pic of model
						List<ModelPhotos> photosOfHouse = property.getModel_photos();
						if (CollectionUtils.isNotEmpty(photosOfHouse)) {
							for (ModelPhotos photo : photosOfHouse) {
								String url = photo.getUrl();
								String subPath = r.getResidenceName() + "/room/";
								String storePath = subPath + "/"
										+ StringUtils.substringAfterLast(url, "com/").replaceAll("/", "-");
								// file
								picCrawler.crawl(url, storePath);
								// db
								HousePicEntity picEntity = new HousePicEntity();
								picEntity.setHouseId(houseId);
								picEntity.setResidenceId(r.getResidenceId());
								picEntity.setType(HousePicEntity.Type.RoomType.getValue());
								picEntity.setAddTime(Calendar.getInstance().getTime());
								picEntity.setUpdateTime(Calendar.getInstance().getTime());
								picEntity.setUrl(storePath);
								housePicService.addHousePic(picEntity);
							}
						}

						// pic of model
						List<RoomPhotos> photosOfRoom = property.getRoom_photos();
						if (CollectionUtils.isNotEmpty(photosOfRoom)) {
							for (RoomPhotos photo : photosOfRoom) {
								String url = photo.getUrl();
								String subPath = r.getResidenceName() + "/house/";
								String storePath = subPath + "/"
										+ StringUtils.substringAfterLast(url, "com/").replaceAll("/", "-");
								// file
								picCrawler.crawl(url, storePath);
								// db
								HousePicEntity picEntity = new HousePicEntity();
								picEntity.setHouseId(houseId);
								picEntity.setResidenceId(r.getResidenceId());
								picEntity.setType(HousePicEntity.Type.HousePic.getValue());
								picEntity.setAddTime(Calendar.getInstance().getTime());
								picEntity.setUpdateTime(Calendar.getInstance().getTime());
								picEntity.setUrl(storePath);
								housePicService.addHousePic(picEntity);
							}
						}

					}

				}

			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}
}
