package com.song.fuckvpn.plugin.api.spec

interface KeyDataSpec {
    /**
     * 密钥的过期时刻
     * @return 过期时刻毫秒值,使用本机时区作为时区,如果密钥永久有效请返回null
     */
    fun getExpireAt(): Long?

    /**
     * 客户端显示的文本
     * @return 显示的文本内容
     */
    fun getViewText(): String

    /**
     * 将密钥转换成订阅链接
     * @param nodeData 节点数据对象 推荐使用 nodeData as MyData 进行类型转换
     * @return 任意协议的订阅链接
     */
    fun toSubscription(nodeData: NodeDataSpec): String
}