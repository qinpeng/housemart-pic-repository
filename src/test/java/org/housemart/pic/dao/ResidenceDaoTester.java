/**
 * Created on 2013-4-21
 * 
 */
package org.housemart.pic.dao;

import java.util.List;

import org.housemart.common.dao.GenericDao;
import org.housemart.pic.model.hm.ResidenceEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/beans/spring*.xml"})
public class ResidenceDaoTester {

	@Autowired
	GenericDao<ResidenceEntity> residenceDao;

	@Test
	public void findResidenceTest() {
		List<ResidenceEntity> residences = residenceDao.select("findResidenceList", null);
		System.out.println(residences.size());
	}

}
