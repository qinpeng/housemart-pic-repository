/**
 * Created on 2013-3-29
 * 
 */
package org.housemart.pic.service.crawl.impl.anjuke.crack;

import java.util.Map;

import junit.framework.Assert;

import org.housemart.pic.service.crawl.anjuke.crack.DecryptSig;
import org.housemart.pic.utils.RequestUtils;
import org.junit.Test;

public class DecryptSigTest {

	@Test
	public void generateHouseListSigTest() throws Exception {
		// http://api.anjuke.com//mobile/1.3/property.searchV3?i=357853047832754&m=Android-GT-I9001&o=GT-I9001-user+2.3.3+GINGERBREAD+ZSKI1+release-keys&v=2.3.3&cv=3.2.1&app=a-anjuke&pm=b23&cid=11&city_id=11&page_size=15&page=1&api_key=eb8cd4ef60fde7580260cf9cf4250a24&q=%E6%96%87%E5%8C%96%E9%A6%A8%E8%8B%91&map_type=baidu&uuid=357853047832754&sig=709d5479f7833804c27ece675eea2d29

		String expSig = "709d5479f7833804c27ece675eea2d29";
		String paraExg = "http://api.anjuke.com//mobile/1.3/property.searchV3?i=357853047832754&m=Android-GT-I9001&o=GT-I9001-user+2.3.3+GINGERBREAD+ZSKI1+release-keys&v=2.3.3&cv=3.2.1&app=a-anjuke&pm=b23&cid=11&city_id=11&page_size=15&page=1&q=文化馨苑&map_type=baidu&uuid=357853047832754";
		Map<String, String> param = RequestUtils.URLRequest(paraExg);
		Map<String, String> significativeParam = DecryptSig.obtainSignificativeParam(param);
		String sig = DecryptSig.generateSig(significativeParam);
		Assert.assertEquals(expSig, sig);
	}

	@Test
	public void generateResidenceDetailSigTest() throws Exception {
		// http://api.anjuke.com/mobile/1.3/community.get?i=357853047832754&m=Android-GT-I9001&o=GT-I9001-user+2.3.3+GINGERBREAD+ZSKI1+release-keys&v=2.3.3&cv=3.2.1&app=a-anjuke&pm=b23&cid=11&id=2718&api_key=eb8cd4ef60fde7580260cf9cf4250a24&maptype=baidu&sig=8f9382b6435f3b25a07cc389692c67bb

		String expSig = "8f9382b6435f3b25a07cc389692c67bb";
		String paraExg = "http://api.anjuke.com/mobile/1.3/community.get?i=357853047832754&m=Android-GT-I9001&o=GT-I9001-user+2.3.3+GINGERBREAD+ZSKI1+release-keys&v=2.3.3&cv=3.2.1&app=a-anjuke&pm=b23&cid=11&id=2718&api_key=eb8cd4ef60fde7580260cf9cf4250a24&maptype=baidu";
		Map<String, String> param = RequestUtils.URLRequest(paraExg);
		Map<String, String> significativeParam = DecryptSig.obtainSignificativeParam(param);
		String sig = DecryptSig.generateSig(significativeParam);
		Assert.assertEquals(expSig, sig);
	}

	@Test
	public void generateURL() throws Exception {
		String paraExg = "http://api.anjuke.com/mobile/1.3/community.get?i=357853047832754&m=Android-GT-I9001&o=GT-I9001-user+2.3.3+GINGERBREAD+ZSKI1+release-keys&v=2.3.3&cv=3.2.1&app=a-anjuke&pm=b23&cid=11&api_key=eb8cd4ef60fde7580260cf9cf4250a24&maptype=baidu&id=291";
		Map<String, String> param = RequestUtils.URLRequest(paraExg);
		Map<String, String> significativeParam = DecryptSig.obtainSignificativeParam(param);
		String sig = DecryptSig.generateSig(significativeParam);
		paraExg = paraExg + "&sig=" + sig;
		System.out.println(paraExg);
	}

}
