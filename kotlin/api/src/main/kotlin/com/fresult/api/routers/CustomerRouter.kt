package com.fresult.api.routers

import com.fresult.models.CustomerResponse
import com.fresult.repositories.CustomerRepository
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.*

@Configuration
class CustomerRouter(private val customerRepository: CustomerRepository) {
  @Bean
  fun routes(): RouterFunction<ServerResponse> = coRouter {
    "/customers".nest {
      GET("") { request ->
        ServerResponse.ok().bodyAndAwait(customerRepository.findAll().map(CustomerResponse::fromEntity).asFlow())
      }

      GET("/{id}") { request ->
        val id = request.pathVariable("id").toLong()
        customerRepository.findById(id)
          .map(CustomerResponse::fromEntity)
          .flatMap(ServerResponse.ok()::bodyValue)
          .awaitSingle()
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