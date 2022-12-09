package com.github.danielmoisa.gitrank.services

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.danielmoisa.gitrank.models.Repo
import com.github.danielmoisa.gitrank.repositories.RepoRepository
import com.github.danielmoisa.gitrank.responseSpec
import com.github.danielmoisa.gitrank.utils.calculateScore
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.util.*

const val oneDay = 24*60*60*1000
@Service()
class GithubService(val repoRepository: RepoRepository) {
    @Scheduled(fixedDelay = oneDay.toLong())
    fun fetchGithubApiScheduler(): MutableList<Repo> {
        val jsonResponseBody: String? = responseSpec.bodyToMono(String::class.java).block()
        val mapper = ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

        val reposNode: JsonNode = mapper.readTree(jsonResponseBody).path("items")
        val reposEntities = mapper.convertValue(reposNode, Array<Repo>::class.java)

        val repos: MutableList<Repo> = ArrayList<Repo>()

        for (repoEntity in reposEntities) {
            repoEntity.score = calculateScore(repoEntity)
            repos.add(repoEntity)
        }
//        LOGGER.info("Github API fetched at: "+LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
        return repoRepository.saveAll((repos))
 }
}