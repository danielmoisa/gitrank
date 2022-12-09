package com.github.danielmoisa.gitrank.controllers

import com.github.danielmoisa.gitrank.models.Repo
import com.github.danielmoisa.gitrank.services.RepoService
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller


@Controller
class RepoController(val repoService: RepoService) {
    @QueryMapping(value = "repos")
    fun getAllRepos(): MutableList<Repo> {
        return repoService.getAllRepos()
    }

    @QueryMapping(value = "reposByScore")
    fun getReposByScore(): MutableList<Repo> {
        return repoService.getReposByScore()
    }

}