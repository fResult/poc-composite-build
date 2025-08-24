package com.fresult.api.handlers

import com.fresult.models.CustomerResponse
import com.fresult.repositories.CustomerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyAndAwait

@Component
class CustomerHandler(private val repository: CustomerRepository) {
  suspend fun all(request: ServerRequest): ServerResponse =
    repository.findAll()
      .map(CustomerResponse::fromEntity)
      .asFlow()
      .toOkResponse()
}

suspend inline fun <reified T : Any> Flow<T>.toOkResponse(): ServerResponse =
  ServerResponse.ok().bodyAndAwait<T>(this)
