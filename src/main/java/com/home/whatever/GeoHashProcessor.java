package com.home.whatever;

import com.streamsets.pipeline.api.Field;
import com.streamsets.pipeline.api.Record;
import com.streamsets.pipeline.api.StageException;
import com.streamsets.pipeline.api.base.SingleLaneRecordProcessor;

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
  }
}
