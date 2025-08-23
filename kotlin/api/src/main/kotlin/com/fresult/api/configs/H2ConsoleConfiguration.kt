package com.fresult.api.configs

import org.h2.tools.Server
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.ContextClosedEvent
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener

@Configuration
class H2ConsoleConfiguration {
  private lateinit var webServer: Server
  private lateinit var tcpServer: Server

  companion object {
    const val WEB_PORT = "8082"
    const val TCP_PORT = "9092"
  }

  @EventListener(ContextRefreshedEvent::class)
  fun start(): Unit {
    webServer = Server.createWebServer("-webPort", WEB_PORT, "-tcpAllowOthers").start()
    tcpServer = Server.createTcpServer("-tcpPort", TCP_PORT, "-tcpAllowOthers").start()
  }

  @EventListener(ContextClosedEvent::class)
  fun stop(): Unit {
    webServer.stop()
    tcpServer.stop()
  }
}
