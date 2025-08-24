package com.fresult.api.routers

import com.fresult.api.handlers.CustomerHandler
import com.fresult.repositories.CustomerRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class CustomerRouter(private val handler: CustomerHandler) {
  @Bean
  fun routes(): RouterFunction<ServerResponse> = coRouter {
    "/customers".nest {
      GET("", handler::all)
      GET("/{id}", handler::byId)
      POST("", handler::create)

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