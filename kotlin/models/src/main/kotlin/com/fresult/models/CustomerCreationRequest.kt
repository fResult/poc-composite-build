package com.fresult.models

import com.fresult.entities.Customer

data class CustomerCreationRequest(val firstName: String, val middleName: String?, val lastName: String) {
  companion object {
    fun toEntity(body: CustomerCreationRequest): Customer =
      Customer(
        id = null,
        fullName = body.fullName(),
      )
  }

  fun fullName(): String {
    return listOfNotNull(firstName, middleName, lastName).unWords()
  }
}

private fun List<String>.unWords(): String {
  return this.joinToString(" ")
}
