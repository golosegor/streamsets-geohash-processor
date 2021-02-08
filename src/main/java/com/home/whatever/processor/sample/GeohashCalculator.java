package com.home.whatever.processor.sample;

import ch.hsr.geohash.GeoHash;

public class GeohashCalculator {

  public String calculate(double latitude, double longtitude, int geohashSize) {
    final GeoHash geoHash = GeoHash.withCharacterPrecision(latitude, longtitude, geohashSize);
    return geoHash.toBase32();
  }
}
