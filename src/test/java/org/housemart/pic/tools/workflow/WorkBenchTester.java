/**
393 * Created on 2013-4-21
 * 
 */
package org.housemart.pic.tools.workflow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/beans/spring*.xml"})
public class WorkBenchTester {
  @Autowired
  WorkBench workBench;
  
  @Test
  public void crawlByRegion() {
    workBench.runByRegionId(389);
  }
  
  @Test
  public void crawlByAdminRegion() {
    workBench.runByAdminRegionId(372);
    workBench.runByAdminRegionId(373);
    workBench.runByAdminRegionId(374);
    workBench.runByAdminRegionId(375);
    workBench.runByAdminRegionId(376);
    workBench.runByAdminRegionId(377);
  }
}
