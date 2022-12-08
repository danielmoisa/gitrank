package com.github.danielmoisa.gitrank

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GitrankApplication

fun main(args: Array<String>) {
	runApplication<GitrankApplication>(*args)
}

