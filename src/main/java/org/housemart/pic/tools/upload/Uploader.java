/**
 * Created on 2013-5-22
 * 
 */
package org.housemart.pic.tools.upload;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.housemart.pic.model.hm.HousePicEntity;
import org.housemart.pic.model.hm.ResidenceEntity;
import org.housemart.pic.service.HousePicService;
import org.housemart.pic.service.HouseService;
import org.housemart.pic.service.ResidenceService;
import org.springframework.beans.factory.annotation.Autowired;

public class Uploader {
  public static final String REQUEST_TOKEN = "817";
  public static final String REQUEST_CONTROLLER = "http://42.121.87.85:8080/repositoryPicUpload.controller";
  public static final String REQUEST_COOKIE = "user=30_1369019984014";
  public static final String PIC_FOLDER = "e:/data/hm/pic";
  
  @Autowired
  ResidenceService residenceService;
  @Autowired
  HouseService houseService;
  @Autowired
  HousePicService housePicService;
  
  public boolean uploadImage(String picPath, String picId) throws ClientProtocolException, IOException {
    
    boolean status = false;
    File file = new File(picPath); // 本地图片路径
    FileBody fileBody = new FileBody(file);
    MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
    entity.addPart("imageFile", fileBody);
    entity.addPart("picId", new StringBody(picId)); // picID
    entity.addPart("token", new StringBody(REQUEST_TOKEN));
    
    HttpPost httppost = new HttpPost(REQUEST_CONTROLLER);
    httppost.setEntity(entity);
    httppost.setHeader("Cookie", REQUEST_COOKIE);
    HttpResponse httpResponse = new DefaultHttpClient().execute(httppost);
    HttpEntity entitys = httpResponse.getEntity();
    String response = EntityUtils.toString(entitys);
    
    System.out.println(httpResponse.getStatusLine().getStatusCode());
    System.out.println(response);
    
    ResponseEntityBean responseBean = new ObjectMapper().readValue(response, ResponseEntityBean.class);
    if (StringUtils.isNotBlank(responseBean.getMsg())) {
      if (responseBean.getMsg().equalsIgnoreCase("success")) status = true;
    }
    
    return status;
    
  }
  
  public void runByRegionId(int regionId) throws ClientProtocolException, IOException {
    List<ResidenceEntity> residencesToCrawl = residenceService.selectResidence(regionId);
    run(residencesToCrawl);
  }
  
  private void run(List<ResidenceEntity> residencesToUpload) throws ClientProtocolException, IOException {
    
    for (ResidenceEntity r : residencesToUpload) {
      List<HousePicEntity> pics = housePicService.findByResidenceId(r.getResidenceId());
      if (CollectionUtils.isNotEmpty(pics)) {
        
        for (HousePicEntity pic : pics) {
          
          if (pic != null && pic.getUrl() != null && pic.getId() != null) {
            boolean uploaded = uploadImage(PIC_FOLDER + "/" + pic.getUrl(), pic.getId().toString());
            if (uploaded) {
              housePicService.updateHousePicAsUploaded(pic.getId());
            }
          }
        }
      }
    }
    
  }
  
}
