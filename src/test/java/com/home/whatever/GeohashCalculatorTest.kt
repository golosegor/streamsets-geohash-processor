package com.home.whatever

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GeohashCalculatorTest {

  @Test
  fun `geohash could be calculated`() {
    val geohashProcessor = GeohashCalculator()
    val geoHash = geohashProcessor.calculate(52.20, 0.12, 6)
    assertThat(geoHash).isEqualTo("u120fw")
  }
}