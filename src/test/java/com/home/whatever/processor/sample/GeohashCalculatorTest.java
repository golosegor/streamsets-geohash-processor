package com.home.whatever.processor.sample;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class GeohashCalculatorTest {
  @Test
  public void geohash_could_be_calculated() {
    final GeohashCalculator geohashCalculator = new GeohashCalculator();
    final String geoHash = geohashCalculator.calculate(52.20, 0.12, 6);
    assertThat(geoHash).isEqualTo("u120fw");
  }
}
