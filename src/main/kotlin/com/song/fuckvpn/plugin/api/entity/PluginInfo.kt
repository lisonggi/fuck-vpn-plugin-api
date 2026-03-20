package com.song.fuckvpn.plugin.api.entity

data class PluginInfo(
    val id: String,
    val name: String,
    val version: String = "1.0",
    val description: String? = null,
    val author: String? = null,
)