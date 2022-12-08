package com.github.danielmoisa.gitrank.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Repo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val name: String = "",
    val ownerName: String = "",
    val ownerHtmlUrl: String = "",
    val repoHtmlUrl: String = "",
    val description: String = "",
    val stars: Int = 0,
    val language: String = "",
)
