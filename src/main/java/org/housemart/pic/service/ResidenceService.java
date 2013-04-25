/**
 * Created on 2013-4-21
 * 
 */
package org.housemart.pic.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.housemart.pic.dao.GenericDao;
import org.housemart.pic.model.hm.ResidenceEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class ResidenceService {
	@Autowired
	GenericDao<ResidenceEntity> residenceDao;

	@SuppressWarnings({"rawtypes", "unchecked"})
	public List<ResidenceEntity> selectResidence(Integer id) {
		Map param = new HashMap();
		param.put("id", id);
		return residenceDao.select("findResidenceList", param);
	}
}
