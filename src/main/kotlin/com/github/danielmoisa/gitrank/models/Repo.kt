package com.github.danielmoisa.gitrank.models

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class Repo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val name: String = "",
    @get:JsonProperty("full_name")
    val fullName: String = "",
    @get:JsonProperty("html_url")
    val repoHtmlUrl: String = "",
    @Column(columnDefinition="TEXT", length = 1000)
    val description: String? = null,
    @get:JsonProperty("stargazers_count")
    val stars: Int = 0,
    val language: String? = null,
)
