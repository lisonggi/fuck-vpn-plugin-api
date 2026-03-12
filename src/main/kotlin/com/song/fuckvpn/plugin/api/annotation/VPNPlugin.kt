package com.song.fuckvpn.plugin.api.annotation

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class VPNPlugin(val id:String,val name:String)