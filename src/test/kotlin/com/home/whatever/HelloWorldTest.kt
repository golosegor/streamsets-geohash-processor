package com.home.whatever

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HelloWorldTest {
  @Test
  fun `my dummy test`() {
    assertThat("5").isEqualTo("5")
  }
}