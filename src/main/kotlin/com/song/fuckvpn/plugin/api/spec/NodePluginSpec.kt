package com.song.fuckvpn.plugin.api.spec

/**
 * 只具有 节点功能 的插件
 */
interface NodePluginSpec {
    fun getPluginInfo(): PluginInfoSpec

    /**
     * 系统在需要节点使用generateNodes函数进行获取
     * @return 节点数据列表
     */
    suspend fun generateNodes(): List<NodeDataSpec>
}