package com.github.danielmoisa.gitrank.controllers

import com.github.danielmoisa.gitrank.models.Repo
import com.github.danielmoisa.gitrank.repositories.RepoRepository
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class RepoController(val repoRepository: RepoRepository) {
    @QueryMapping(value = "repos")
    fun getAllRepos(): List<Repo> {
        return repoRepository.findAll()
    }
    @MutationMapping(name = "createRepo")
    fun createRepo(@Argument(name = "repo") repo: Repo): Repo {
        return repoRepository.save(repo)
    }

}