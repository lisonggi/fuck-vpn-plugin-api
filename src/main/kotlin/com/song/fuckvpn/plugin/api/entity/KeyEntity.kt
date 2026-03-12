package com.song.fuckvpn.plugin.api.entity

interface KeyEntity: TimeLeft {
    val id: Long
    val label: String
    val key: String
    val dataLeft: String
    val generateTime: Long
    fun toValue(): String
}