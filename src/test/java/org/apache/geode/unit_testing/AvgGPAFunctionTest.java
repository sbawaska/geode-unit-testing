package org.apache.geode.unit_testing;

import org.apache.geode.cache.execute.RegionFunctionContext;
import org.apache.geode.cache.execute.ResultSender;
import org.apache.geode.internal.cache.LocalDataSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collection;
import java.util.HashSet;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by sbawaskar on 5/14/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class AvgGPAFunctionTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Mock
  private RegionFunctionContext mockRegionFunctionContext;

  @Mock
  private LocalDataSet mockRegion;

  @Mock
  private ResultSender mockResultSender;

  @Test
  public void executeComputesCorrectAverage() throws Exception {
    AvgGPAFunction function = new AvgGPAFunction();
    when(mockRegionFunctionContext.getDataSet()).thenReturn(mockRegion);
    when(mockRegion.values()).thenReturn(validStudentCollection());
    when(mockRegionFunctionContext.getResultSender()).thenReturn(mockResultSender);
    function.execute(mockRegionFunctionContext);
    verify(mockResultSender).lastResult(ArgumentMatchers.eq(2.5F));
  }

  private Collection validStudentCollection() {
    Collection c = new HashSet();
    for (int i=1; i<5; i++) {
      c.add(new Student(i, "name"+i, i*1.0F));
    }
    return c;
  }

}
