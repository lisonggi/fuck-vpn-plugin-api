package com.song.fuckvpn.plugin.api

import com.song.fuckvpn.plugin.api.model.NodeData
import com.song.fuckvpn.plugin.api.model.PluginInfo

interface NodePlugin {
    fun getPluginInfo(): PluginInfo

    /**
     * 生成节点
     */
    suspend fun generateNodes(): Set<NodeData>
}