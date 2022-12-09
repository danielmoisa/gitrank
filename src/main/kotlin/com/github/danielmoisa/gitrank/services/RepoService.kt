package com.github.danielmoisa.gitrank.services

import com.github.danielmoisa.gitrank.models.Repo
import com.github.danielmoisa.gitrank.repositories.RepoRepository
import org.springframework.stereotype.Service

@Service
class RepoService(val repoRepository: RepoRepository) {
    fun getAllRepos(): MutableList<Repo> {
        return repoRepository.findAll()
    }

}