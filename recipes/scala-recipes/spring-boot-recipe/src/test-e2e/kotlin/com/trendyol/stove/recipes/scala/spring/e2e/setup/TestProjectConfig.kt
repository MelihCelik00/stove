package com.trendyol.stove.recipes.scala.spring.e2e.setup

import com.trendyol.stove.recipes.scala.spring.SpringBootRecipeApp
import com.trendyol.stove.testing.e2e.*
import com.trendyol.stove.testing.e2e.http.*
import com.trendyol.stove.testing.e2e.system.TestSystem
import io.kotest.core.config.AbstractProjectConfig

class TestProjectConfig : AbstractProjectConfig() {
  override suspend fun beforeProject() {
    TestSystem("http://localhost:8080").with {
      httpClient {
        HttpClientSystemOptions()
      }
      bridge()
      springBoot(
        runner = { parameters ->
          SpringBootRecipeApp.run(parameters) {
          }
        },
        withParameters = listOf()
      )
    }.run()
  }

  override suspend fun afterProject() {
    TestSystem.stop()
  }
}
