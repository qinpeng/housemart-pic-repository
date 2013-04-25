/**
 * Created on 2013-4-26
 * 
 */
package org.housemart.pic.service;

import org.housemart.pic.dao.GenericDao;
import org.housemart.pic.model.hm.HousePicEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class HousePicService {
	@Autowired
	GenericDao<HousePicEntity> housePicDao;

	public int addHousePic(HousePicEntity housePic) {
		return housePicDao.add("addHousePic", housePic);
	}
}
