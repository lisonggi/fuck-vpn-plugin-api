package com.song.fuckvpn.plugin.api.model

interface NodeData {
    val data: String
    val createTime: Long
    fun getViewText(): String
    fun toSubscription(): String
}