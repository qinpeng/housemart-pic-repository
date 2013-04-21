/**
 * Created on 2013-4-21
 * 
 */
package org.housemart.pic.service;

import java.util.List;

import org.housemart.pic.dao.GenericDao;
import org.housemart.pic.model.hm.ResidenceEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class ResidenceService {
	@Autowired
	GenericDao<ResidenceEntity> residencdDao;

	public List<ResidenceEntity> selectAllResidence() {
		return residencdDao.select("findResidenceList", null);
	}
}
