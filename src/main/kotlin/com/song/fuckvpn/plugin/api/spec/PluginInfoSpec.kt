package com.song.fuckvpn.plugin.api.spec
interface PluginInfoIDSpec{
    /**
     * 插件唯一id,必须全球唯一
     */
    val id: String
}
interface PluginInfoSpec:PluginInfoIDSpec{
    /**
     * 前端列表中显示的名称
     */
    val name: String
    /**
     * 版本号
     */
    val version: String
    /**
     * 作者
     */
    val author: String?
    /**
     * 描述
     */
    val description: String?
}