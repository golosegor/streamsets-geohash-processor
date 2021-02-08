package com.home.whatever

import ch.hsr.geohash.GeoHash
import com.streamsets.pipeline.api.Field
import com.streamsets.pipeline.api.Record
import com.streamsets.pipeline.api.base.SingleLaneRecordProcessor
import mu.KLogging

class GeohashProcessor : SingleLaneRecordProcessor() {
  companion object : KLogging() {
    val GEOHASH_SIZE: Int = 4
  }

  override fun process(record: Record?, batchMaker: SingleLaneBatchMaker?) {
    record?.let { r ->
      logger.info { "Processing record $r" }
      val latitude = r.get("Latitude").valueAsDouble
      val longtitude = r.get("Longitude").valueAsDouble
      val geoHash = calculate(latitude = latitude, longtitude = longtitude)
      r.set("Geohash", Field.create(geoHash))
      latitude
    }
  }

  internal fun calculate(
    latitude: Double,
    longtitude: Double,
    geohashSize: Int = GEOHASH_SIZE
  ): String {
    logger.info { "Calculating geohash for $latitude & $longtitude" }
    val geoHash = GeoHash.withCharacterPrecision(latitude, longtitude, geohashSize)
    logger.info { "Geohash for lat: $latitude and long: $longtitude : $geoHash" }
    return geoHash.toBase32()
  }
}