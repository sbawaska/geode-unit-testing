package org.apache.geode.unit_testing;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.execute.Function;
import org.apache.geode.cache.execute.FunctionContext;
import org.apache.geode.cache.execute.RegionFunctionContext;
import org.apache.geode.cache.partition.PartitionRegionHelper;

/**
 * Created by sbawaskar on 5/14/18.
 */
public class AvgGPAFunction implements Function<Student> {

  @Override
  public void execute(FunctionContext<Student> context) {
    RegionFunctionContext rfc = (RegionFunctionContext) context;
    Region<Integer, Student> studentRegion = PartitionRegionHelper.getLocalData(rfc.getDataSet());
    float total = 0;
    int count = 0;
    for (Student s : studentRegion.values()) {
      count++;
      total += s.getGpa();
    }
    float result = total / count;
    context.getResultSender().lastResult(result);

  }
}
