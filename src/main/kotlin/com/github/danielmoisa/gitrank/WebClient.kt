package com.github.danielmoisa.gitrank

import org.springframework.web.reactive.function.client.WebClient

const val GITHUB_API_URL = "https://api.github.com/search/repositories?q=stars:>1&sort=stars&per_page=100"

var client = WebClient.create()

var responseSpec = client.get()
    .uri(GITHUB_API_URL)
    .retrieve()
