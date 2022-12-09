package com.github.danielmoisa.gitrank.services

import com.github.danielmoisa.gitrank.models.Repo
import com.github.danielmoisa.gitrank.repositories.RepoRepository
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class RepoService(val repoRepository: RepoRepository) {
    fun getAllRepos(): MutableList<Repo> {
        return repoRepository.findAll()
    }

    fun getReposByScore(): MutableList<Repo> {
        return repoRepository.findAll(Sort.by(Sort.Direction.DESC, "score"));
    }

}