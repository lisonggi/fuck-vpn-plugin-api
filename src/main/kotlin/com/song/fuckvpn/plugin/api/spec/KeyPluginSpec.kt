package com.song.fuckvpn.plugin.api.spec

/**
 * 具有 节点功能 且 具有密钥功能 的插件
 */
interface KeyPluginSpec : NodePluginSpec {
    /**
     * 生成密钥
     * @return KeyDataSpec
     */
    suspend fun generateKey(): KeyDataSpec
}