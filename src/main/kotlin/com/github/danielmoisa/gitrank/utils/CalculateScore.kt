package com.github.danielmoisa.gitrank.utils

import com.github.danielmoisa.gitrank.models.Repo

fun calculateScore(repo: Repo): Int {
    var score = 0

    score += repo.stars
    score += repo.forks
    score += repo.watchers
    score += repo.linesOfCode
    score += repo.openedIssues

    return score / 5
}