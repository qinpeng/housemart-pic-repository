/**
 * Created on 2013-5-23
 * 
 */
package org.housemart.pic.tools.upload;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/beans/spring*.xml" })
public class UploaderTest {
	@Autowired
	Uploader uploader;

	@Test
	public void runByRegion() throws Exception {
		uploader.runByRegionId(380);
	}

	@Test
	public void runByAdminRegion() throws Exception {
		uploader.runByAdminRegionId(374);
		uploader.runByAdminRegionId(375);
		uploader.runByAdminRegionId(376);
		uploader.runByAdminRegionId(377);
	}

	@Test
	public void runByIds() throws Exception {
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(10974);
		ids.add(11075);
		ids.add(11305);
		ids.add(10317);
		ids.add(10006);
		ids.add(3857);
		ids.add(2188);
		ids.add(1977);
		ids.add(3829);
		ids.add(3833);
		ids.add(3485);
		ids.add(5792);
		ids.add(5893);
		ids.add(6901);
		ids.add(2771);
		ids.add(6294);
		ids.add(8678);
		ids.add(8842);
		ids.add(9403);
		ids.add(8839);
		uploader.runByResidenceIds(ids);
	}
}
