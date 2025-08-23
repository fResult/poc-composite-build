package com.fresult.api

import com.fresult.api.configs.H2ConsoleConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@SpringBootApplication
@EnableR2dbcRepositories(basePackages = [/*"com.fresult.api",*/ "com.fresult.repositories"])
@EntityScan("com.fresult.entities")
@Import(H2ConsoleConfiguration::class)
class CustomerApplication

fun main(args: Array<String>) {
  runApplication<CustomerApplication>(*args)
}
