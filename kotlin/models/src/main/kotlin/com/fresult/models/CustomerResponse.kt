package com.fresult.models

import com.fresult.entities.Customer

data class CustomerResponse(val id: Long, val firstName: String, val middleName: String?, val lastName: String) {
  companion object {
    fun fromEntity(entity: Customer): CustomerResponse {
      val names = entity.fullName.words()
      if (names.size < 2) {
        throw IllegalArgumentException("Full name must contain at least first name and last name")
      }

      return CustomerResponse(
        id = entity.id!!,
        firstName = names.first(),
        middleName = if (names.size > 2) names[1] else null,
        lastName = names.last(),
      )
    }
  }
}

private fun String.words(): List<String> {
  return this.split(" ").filter(String::isNotBlank)
}
