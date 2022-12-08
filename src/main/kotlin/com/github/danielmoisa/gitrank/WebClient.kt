package com.github.danielmoisa.gitrank

import org.springframework.web.reactive.function.client.WebClient

var client = WebClient.create()

var responseSpec = client.get()
    .uri("https://api.github.com/search/repositories?q=stars:>1&sort=stars")
    .retrieve()
