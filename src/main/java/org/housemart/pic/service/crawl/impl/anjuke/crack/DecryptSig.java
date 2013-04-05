/**
 * Created on 2013-3-29
 * 
 */
package org.housemart.pic.service.crawl.impl.anjuke.crack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.housemart.pic.utils.EncryptUtils;

public class DecryptSig {
	private static String apiKey = "eb8cd4ef60fde7580260cf9cf4250a24";
	private static String privateKey = "5d41a9e970273bca";

	/**
	 * 获取用于加密的参数
	 * 
	 * @param param
	 * @return
	 */
	public static Map<String, String> obtainSignificativeParam(Map<String, String> param) {
		Map<String, String> ret = new HashMap<String, String>();
		ret.put("city_id", param.get("city_id"));
		ret.put("uuid", param.get("uuid"));
		ret.put("q", param.get("q"));
		ret.put("page", param.get("page"));
		ret.put("page_size", param.get("page_size"));
		ret.put("map_type", param.get("map_type"));
		return ret;
	}

	public static String generateSig(Map<String, String> param) throws Exception {
		return EncryptUtils.md5(encryptParameterList(param) + privateKey).toLowerCase();
	}

	/**
	 * 安居客的一系列加密方法
	 * 
	 * @param param
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	private static String encryptParameterList(Map<String, String> param) {
		ArrayList localArrayList = new ArrayList();
		Iterator localIterator1 = param.entrySet().iterator();
		StringBuffer localStringBuffer;
		Iterator localIterator2;

		localArrayList.add("api_key=" + apiKey);
		localStringBuffer = new StringBuffer();

		while (localIterator1.hasNext()) {
			Map.Entry localEntry = (Map.Entry) localIterator1.next();
			Object localObject1 = localEntry.getKey();
			Object localObject2 = localEntry.getValue();
			localArrayList.add(localObject1 + "=" + localObject2);
		}
		Collections.sort(localArrayList);

		localIterator2 = localArrayList.iterator();
		while (localIterator2.hasNext()) {
			String str = (String) localIterator2.next();
			if (localStringBuffer.toString().length() == 0)
				localStringBuffer.append(str);
			else
				localStringBuffer.append("&" + str);
		}

		return localStringBuffer.toString();
	}

}
