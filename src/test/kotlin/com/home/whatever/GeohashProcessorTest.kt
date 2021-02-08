package com.home.whatever

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GeohashProcessorTest {

  @Test
  fun `geohash could be calculated`() {
    val geohashProcessor = GeohashProcessor()
    val geoHash = geohashProcessor.calculate(52.20, 0.12, 6)
    assertThat(geoHash).isEqualTo("u120fw")
  }
}