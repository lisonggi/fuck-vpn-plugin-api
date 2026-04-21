package com.song.fuckvpn.plugin.api.spec

interface NodeDataSpec {
    /**
     * 节点名称
     * 排序时会参考名称进行排序,并将首位节点拷贝为默认节点
     * @return 名称
     */
    var name: String

    /**
     * 复制节点
     * @sample
     * 建议使用 this.copy()
     *     override fun copy(): NodeDataSpec = copy(name = name)
     * @return 复制后的对象
     */
    fun copy(): NodeDataSpec

    /**
     * 客户端显示的文本
     * @return 显示的文本内容
     */
    fun getViewText(): String

    /**
     * 转换为订阅链接
     * @return 任意协议的订阅链接
     */
    fun toSubscription(): String
}