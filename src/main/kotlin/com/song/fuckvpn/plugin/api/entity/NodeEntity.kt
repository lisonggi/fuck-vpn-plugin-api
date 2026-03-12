package com.song.fuckvpn.plugin.api.entity

interface NodeEntity {
    var id: Int
    var label: String
    var country: String
    var ip: String
    var port: Int
    val url: String
    var dateTime: Long
    fun toLink(token: KeyEntity): String
}