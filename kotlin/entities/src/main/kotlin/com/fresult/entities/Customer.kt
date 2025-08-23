package com.fresult.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("customers")
data class Customer(@Id val id: Long?, val fullName: String)
