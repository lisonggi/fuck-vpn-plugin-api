package com.song.fuckvpn.plugin.api.annotation

/**
 * 插件必须被 @VPNPlugin 才可以被系统识别
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class VPNPlugin