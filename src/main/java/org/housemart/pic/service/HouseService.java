/**
 * Created on 2013-4-25
 * 
 */
package org.housemart.pic.service;

import org.housemart.pic.dao.GenericDao;
import org.housemart.pic.model.hm.HouseEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class HouseService {
	@Autowired
	GenericDao<HouseEntity> houseDao;

	public int addHouse(HouseEntity house) {
		return houseDao.add("addHouse", house);
	}
}
