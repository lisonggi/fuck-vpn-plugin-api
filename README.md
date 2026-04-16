# fuck-vpn-plugin-api

`fuck-vpn-plugin-api` 是 `fuck-vpn-server` 的插件接口库，定义插件元信息、节点数据和密钥数据模型。该库为插件开发和运行时自动扫描提供统一契约。

相关项目：
- [fuck-vpn-server](https://github.com/lisonggi/fuck-vpn-server)
- [fuck-vpn-web](https://github.com/lisonggi/fuck-vpn-web)

## 核心接口

- `NodePlugin`：基础节点插件接口，负责插件信息和节点生成。
- `KeyPlugin`：继承 `NodePlugin`，增加密钥生成能力。
- `@VPNPlugin`：用于标记插件实现类，运行时可自动扫描加载。
- `PluginInfo`：描述插件 id、名称、版本、作者和描述。
- `NodeData`：节点数据模型，支持订阅链接生成和展示文本。
- `KeyData`：密钥数据模型，支持过期时间和展示文本。

## 目录结构

- `src/main/kotlin/com/song/fuckvpn/plugin/api/annotation/VPNPlugin.kt`
- `src/main/kotlin/com/song/fuckvpn/plugin/api/NodePlugin.kt`
- `src/main/kotlin/com/song/fuckvpn/plugin/api/KeyPlugin.kt`
- `src/main/kotlin/com/song/fuckvpn/plugin/api/model/PluginInfo.kt`
- `src/main/kotlin/com/song/fuckvpn/plugin/api/model/NodeData.kt`
- `src/main/kotlin/com/song/fuckvpn/plugin/api/model/KeyData.kt`

## 使用方式

项目默认 Maven/Gradle 坐标：

```kotlin
implementation("com.song:fuck-vpn-plugin-api:1.0")
```

本地开发时，也可以通过 `includeBuild` 或 `project(":fuck-vpn-plugin-api")` 方式引用。

## 插件类型

### NodePlugin

适用于无需密钥的节点插件，必须实现：

- `getPluginInfo()`
- `generateNodes()`

### KeyPlugin

适用于需要密钥的节点插件，必须实现：

- `getPluginInfo()`
- `generateNodes()`
- `generateKey()`

## 数据模型说明

### PluginInfo

包含插件标识、名称、版本、作者和描述等基础信息。

### NodeData

- `data: String`：建议以 JSON 保存完整业务数据。
- `createTime: Long`：节点创建时间。
- `getViewText(): String`：用于管理界面展示节点摘要。
- `toSubscription(keyData: KeyData?): String`：生成订阅链接。

当插件为 `KeyPlugin` 时，运行时会传入 `keyData`，用于构造最终订阅链接。

### KeyData

- `data: String`：建议以 JSON 保存完整密钥数据。
- `createTime: Long`：密钥创建时间。
- `getExpireAt(): Long?`：返回过期时间戳，用于判断是否失效。
- `getViewText(): String`：用于管理界面展示密钥信息。

## 插件实现示例

```kotlin
@VPNPlugin
class ExampleNodePlugin : NodePlugin {
    override fun getPluginInfo() = PluginInfo(
        id = "example-node-plugin",
        name = "Example Node Plugin",
        version = "1.0.0",
        author = "author",
        description = "示例节点插件"
    )

    override suspend fun generateNodes(): Set<NodeData> {
        return setOf(
            object : NodeData {
                override val data = "{\"host\":\"1.1.1.1\",\"port\":443}"
                override val createTime = System.currentTimeMillis()
                override fun getViewText() = "1.1.1.1:443"
                override fun toSubscription(keyData: KeyData?) = "vless://example@1.1.1.1:443"
            }
        )
    }
}
```

如果需要密钥管理，可实现 `KeyPlugin`：

```kotlin
@VPNPlugin
class ExampleKeyPlugin : KeyPlugin {
    override fun getPluginInfo() = ...
    override suspend fun generateNodes() = ...
    override suspend fun generateKey() = ...
}
```

## 构建与测试

```bash
./gradlew clean build
./gradlew test
```

## 说明

本项目仅提供插件接口定义，不包含具体业务实现。`fuck-vpn-server` 可依赖本库进行插件扫描与扩展。
