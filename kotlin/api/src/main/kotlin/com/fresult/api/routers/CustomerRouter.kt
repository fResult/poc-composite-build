package com.fresult.api.routers

import com.fresult.entities.Customer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.coRouter
import com.fresult.repositories.CustomerRepository
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.web.reactive.function.server.bodyAndAwait
import org.springframework.web.reactive.function.server.buildAndAwait

@Configuration
class CustomerRouter(private val customerRepository: CustomerRepository) {
  @Bean
  fun routes(): RouterFunction<ServerResponse> = coRouter {
    "/customers".nest {
      GET("") { request ->
        ServerResponse.ok().bodyAndAwait(customerRepository.findAll().asFlow())
      }

      GET("/{id}") { request ->
        val id = request.pathVariable("id").toLong()
        customerRepository.findById(id).flatMap(ServerResponse.ok()::bodyValue).awaitSingle()
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