package com.github.danielmoisa.gitrank.utils

import com.github.danielmoisa.gitrank.models.Repo

fun calculateScore(repo: Repo): Int {
    var score = 0

    score += repo.stars * 5
    score += repo.forks * 3
    score += repo.watchers * 2
    score += repo.linesOfCode * 2
    score += repo.openedIssues / 5

    return score
}