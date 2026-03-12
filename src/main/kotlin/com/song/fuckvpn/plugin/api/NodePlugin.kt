package com.song.fuckvpn.plugin.api

import com.song.fuckvpn.plugin.api.entity.NodeEntity

interface NodePlugin  {
    /**
     * 生成节点
     */
    fun generateNode(): List<NodeEntity>
}