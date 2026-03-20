package com.song.fuckvpn.plugin.api

import com.song.fuckvpn.plugin.api.entity.NodeEntity
import com.song.fuckvpn.plugin.api.entity.PluginInfo

interface NodePlugin {
    fun getPluginInfo(): PluginInfo

    /**
     * 生成节点
     */
    fun generateNodes(): Set<NodeEntity>
}