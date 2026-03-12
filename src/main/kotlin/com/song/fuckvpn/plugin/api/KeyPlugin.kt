package com.song.fuckvpn.plugin.api

import com.song.fuckvpn.plugin.api.entity.KeyEntity

interface KeyPlugin : NodePlugin {
    /**
     * 生成密钥
     */
    fun generateKey(): KeyEntity
}