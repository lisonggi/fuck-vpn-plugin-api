package com.song.fuckvpn.plugin.api

import com.song.fuckvpn.plugin.api.entity.NodeEntity
import com.song.fuckvpn.plugin.api.entity.PluginInfo

interface NodePlugin {
    suspend fun getPluginInfo(): PluginInfo

    /**
     * 生成节点
     */
    suspend fun generateNodes(): Set<NodeEntity>
}