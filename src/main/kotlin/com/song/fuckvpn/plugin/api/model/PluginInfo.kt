package com.song.fuckvpn.plugin.api.model

data class PluginInfo(
    /**
     * 插件唯一id,必须全球唯一
     */
    val id: String,
    /**
     * 前端列表中显示的名称
     */
    val name: String,
    /**
     * 版本号
     */
    val version: String,
    /**
     * 作者
     */
    val author: String? = null,
    /**
     * 描述
     */
    val description: String? = null,
)