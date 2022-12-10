package com.github.danielmoisa.gitrank

import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient

const val GITHUB_API_URL = "https://api.github.com/search/repositories?q=stars:>1&per_page=1000"

var webClient = WebClient.builder().exchangeStrategies(
    ExchangeStrategies.builder().codecs {
        it.defaultCodecs().maxInMemorySize(1000000)
        }.build()
    ).build()

var responseSpec = webClient.get()
    .uri(GITHUB_API_URL)
    .retrieve()
