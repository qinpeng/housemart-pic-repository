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

@SuppressWarnings({"rawtypes", "unchecked"})
public class ResidenceService {
	@Autowired
	GenericDao<ResidenceEntity> residenceDao;

	public List<ResidenceEntity> selectResidence(Integer regionId) {
		Map param = new HashMap();
		param.put("id", regionId);
		return residenceDao.select("findResidenceList", param);
	}

	public List<ResidenceEntity> selectResidenceByAdminRegion(Integer regionId) {
		Map param = new HashMap();
		param.put("id", regionId);
		return residenceDao.select("findResidenceListByAdminRegion", param);
	}
}
