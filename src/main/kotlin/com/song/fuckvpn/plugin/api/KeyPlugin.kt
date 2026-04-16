package com.song.fuckvpn.plugin.api

import com.song.fuckvpn.plugin.api.model.KeyData

interface KeyPlugin : NodePlugin {
    /**
     * 生成密钥
     */
    suspend fun generateKey(): KeyData
}