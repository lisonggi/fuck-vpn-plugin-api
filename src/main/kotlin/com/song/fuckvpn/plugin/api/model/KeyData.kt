package com.song.fuckvpn.plugin.api.model

interface KeyData {
    val data: String
    val createTime: Long
    fun getExpireAt(): Long?
    fun getViewText(): String
    fun toSubscription(nodeDataList: List<NodeData>): String
}