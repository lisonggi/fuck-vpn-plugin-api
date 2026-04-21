package com.song.fuckvpn.plugin.api.model

import com.song.fuckvpn.plugin.api.spec.PluginInfoSpec

data class PluginInfo(
    override val id: String,
    override val name: String,
    override val version: String,
    override val author: String? = null,
    override val description: String? = null,
) : PluginInfoSpec