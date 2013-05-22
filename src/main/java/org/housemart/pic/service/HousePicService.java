/**
 * Created on 2013-4-26
 * 
 */
package org.housemart.pic.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.housemart.pic.dao.GenericDao;
import org.housemart.pic.model.hm.HousePicEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class HousePicService {
  @Autowired
  GenericDao<HousePicEntity> housePicDao;
  
  public int addHousePic(HousePicEntity housePic) {
    return housePicDao.add("addHousePic", housePic);
  }
  
  @SuppressWarnings({"unchecked", "rawtypes"})
  public List<HousePicEntity> findByResidenceId(int id) {
    Map para = new HashMap();
    para.put("id", id);
    return housePicDao.select("findPicNotUploadByResidence", para);
  }
  
  @SuppressWarnings({"unchecked", "rawtypes"})
  public void updateHousePicAsUploaded(int id) {
    Map para = new HashMap();
    para.put("id", id);
    para.put("status", 1);
    para.put("updateTime", Calendar.getInstance().getTime());
    housePicDao.update("updateHousePicStatus", para);
    
  }
}
