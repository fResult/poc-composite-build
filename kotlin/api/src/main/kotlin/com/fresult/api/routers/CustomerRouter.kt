package com.fresult.api.routers

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class CustomerRouter {
  @Bean
  fun routes(): RouterFunction<ServerResponse> = coRouter {
    "/customers".nest {
      GET("") { request ->
        ServerResponse.ok().bodyValueAndAwait("List of customers")
      }

      GET("/{id}") { request ->
        val id = request.pathVariable("id")
        ServerResponse.ok().bodyValueAndAwait("Customer with id: $id")
      }

      POST("") { request ->
        ServerResponse.ok().bodyValueAndAwait("Customer created")
      }

      PATCH("/{id}") { request ->
        val id = request.pathVariable("id")
        ServerResponse.ok().bodyValueAndAwait("Customer with id: $id updated")
      }

      DELETE("/{id}") { request ->
        val id = request.pathVariable("id")
        ServerResponse.ok().bodyValueAndAwait("Customer with id: $id deleted")
      }
    }
  }
}