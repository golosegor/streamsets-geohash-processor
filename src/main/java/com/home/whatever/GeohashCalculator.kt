package com.home.whatever

import ch.hsr.geohash.GeoHash
import mu.KLogging

class GeohashCalculator {
  companion object : KLogging() {
    val GEOHASH_SIZE: Int = 4
  }

  fun calculate(
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