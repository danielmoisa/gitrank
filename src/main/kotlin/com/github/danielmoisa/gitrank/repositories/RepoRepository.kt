package com.github.danielmoisa.gitrank.repositories

import com.github.danielmoisa.gitrank.models.Repo
import org.springframework.data.jpa.repository.JpaRepository

interface RepoRepository: JpaRepository<Repo, Int> {
}