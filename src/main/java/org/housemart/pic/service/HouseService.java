/**
 * Created on 2013-4-25
 * 
 */
package org.housemart.pic.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.housemart.pic.dao.GenericDao;
import org.housemart.pic.model.hm.HouseEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class HouseService {
	@Autowired
	GenericDao<HouseEntity> houseDao;

	public int addHouse(HouseEntity house) {
		return houseDao.add("addHouse", house);
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public boolean isResidenceCrawled(int residenceId) {
		Map param = new HashMap();
		param.put("id", residenceId);
		List<HouseEntity> houseList = houseDao.select("findHouseByResicendeId", param);
		return (!CollectionUtils.isEmpty(houseList));
	}
}
