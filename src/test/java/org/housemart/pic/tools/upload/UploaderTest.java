/**
 * Created on 2013-5-23
 * 
 */
package org.housemart.pic.tools.upload;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/beans/spring*.xml"})
public class UploaderTest {
  @Autowired
  Uploader uploader;
  
  @Test
  public void runByRegion() throws ClientProtocolException, IOException {
    uploader.runByRegionId(380);
  }
}
