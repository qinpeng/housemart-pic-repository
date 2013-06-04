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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
	public static final String PIC_FOLDER = "d:/data/hm/pic";

	private static final Log log = LogFactory.getLog(Uploader.class);
	private static final String ERROR_SERVER = "server error";
	private static final String ERROR_FILE_NOT_FOUND = "file not found";
	private static final String ERROR_HESSIAN = "hessian handle error";
	private static final String ERROR_TOKEN = "token not right";
	private String message;

	@Autowired
	ResidenceService residenceService;
	@Autowired
	HouseService houseService;
	@Autowired
	HousePicService housePicService;

	public void runByAdminRegionId(int adminRegionId) throws Exception {
		List<ResidenceEntity> residencesToCrawl = residenceService
				.selectResidenceByAdminRegion(adminRegionId);
		run(residencesToCrawl);
	}

	public void runByRegionId(int regionId) throws Exception {
		List<ResidenceEntity> residencesToCrawl = residenceService
				.selectResidence(regionId);
		run(residencesToCrawl);
	}

	public void runByResidenceIds(List<Integer> residenceId) throws Exception {
		List<ResidenceEntity> residencesToCrawl = residenceService
				.selectResidenceByIds(residenceId);
		run(residencesToCrawl);
	}

	public boolean uploadImage(String picPath, String picId)
			throws ClientProtocolException, IOException {

		boolean status = false;
		File file = new File(picPath); // 本地图片路径
		FileBody fileBody = new FileBody(file);
		MultipartEntity entity = new MultipartEntity(
				HttpMultipartMode.BROWSER_COMPATIBLE);
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

		if (httpResponse.getStatusLine().getStatusCode() != 200) {
			message = ERROR_SERVER;
			return false;
		}

		ResponseEntityBean responseBean = new ObjectMapper().readValue(
				response, ResponseEntityBean.class);
		message = null;
		if (StringUtils.isNotBlank(responseBean.getMsg())) {
			message = responseBean.getMsg();
			if (responseBean.getMsg().equalsIgnoreCase("success"))
				status = true;
		}

		return status;

	}

	private void run(List<ResidenceEntity> residencesToUpload) throws Exception {

		for (ResidenceEntity r : residencesToUpload) {
			List<HousePicEntity> pics = housePicService.findByResidenceId(r
					.getResidenceId());
			log.info("rid:" + r.getResidenceId() + " rname:"
					+ r.getResidenceName());
			if (CollectionUtils.isNotEmpty(pics)) {

				for (HousePicEntity pic : pics) {

					if (pic != null && pic.getUrl() != null
							&& pic.getId() != null) {
						try {
							boolean uploaded = uploadImage(PIC_FOLDER + "/"
									+ pic.getUrl(), pic.getId().toString());

							System.out.println("pid " + pic.getId().toString());
							if (uploaded) {
								housePicService.updateHousePicAsUploaded(pic
										.getId());
							} else {
								log.info(pic.getId() + " " + message);
								if (message.equals(ERROR_HESSIAN))
									Thread.sleep(60000 * 1);
								if (message.equals(ERROR_SERVER))
									Thread.sleep(60000 * 1);
								if (message.equals(ERROR_TOKEN))
									throw new Exception(ERROR_TOKEN);
							}
						} catch (Exception e) {
							Thread.sleep(60000 * 1);
							log.error(e.getMessage(), e);
						}
					}
				}
			}
		}

	}
}
