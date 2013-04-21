/**
 * Created on 2013-4-21
 * 
 */
package org.housemart.pic.tools.workflow;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.housemart.pic.model.anjuke.Property;
import org.housemart.pic.model.hm.ResidenceEntity;
import org.housemart.pic.service.ResidenceService;
import org.housemart.pic.service.crawl.impl.anjuke.AnJuKeConstants;
import org.housemart.pic.service.crawl.impl.anjuke.search.CommunitySearcher;
import org.housemart.pic.service.crawl.impl.anjuke.search.HouseListSearcher;
import org.springframework.beans.factory.annotation.Autowired;

public class WorkBench {
	@Autowired
	ResidenceService residenceService;
	@Autowired
	HouseListSearcher houseListSearcher;
	@Autowired
	CommunitySearcher communitySearcher;

	public void run() {
		List<ResidenceEntity> residencesToCrawl = residenceService.selectAllResidence();

		for (ResidenceEntity r : residencesToCrawl) {

			try {

				List<Property> houses = houseListSearcher.search(AnJuKeConstants.CITY_SHANGHAI, r.getResidenceName()
						.trim());
				if (CollectionUtils.isNotEmpty(houses)) {
					String communityId = houses.get(0).getCommunity().getId();
					System.out.println(communitySearcher.search(communityId));;
					System.out.println(houses.size());
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
