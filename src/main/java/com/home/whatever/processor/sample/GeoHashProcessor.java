package com.home.whatever.processor.sample;

import com.streamsets.pipeline.api.Field;
import com.streamsets.pipeline.api.GenerateResourceBundle;
import com.streamsets.pipeline.api.Record;
import com.streamsets.pipeline.api.StageDef;
import com.streamsets.pipeline.api.StageException;
import com.streamsets.pipeline.api.base.SingleLaneRecordProcessor;

@StageDef(
    version = 1,
    label = "GeoHashGenerator",
    description = "",
    icon = "default.png",
    onlineHelpRefUrl = ""
)
@GenerateResourceBundle
public class GeoHashProcessor extends SingleLaneRecordProcessor {
  private GeohashCalculator geohashCalculator = new GeohashCalculator();

  @Override
  protected void process(
      final Record record, final SingleLaneBatchMaker batchMaker
  ) throws StageException {
    final double latitude = record.get("Latitude").getValueAsDouble();
    final double longitude = record.get("Longitude").getValueAsDouble();
    final String geoHash = geohashCalculator.calculate(latitude, longitude, 4);
    record.set("Geohash", Field.create(geoHash));
    batchMaker.addRecord(record);
  }
}
