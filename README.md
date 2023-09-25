
## 友情提醒
master 为项目全量代码，建议读者根据章节顺序，切换到每个章节对应的代码分支，循序渐进学习。

## 更多精彩
更多源码阅读技巧相关的文章，欢迎关注 《闪电侠的博客》



# netty
BIO和NIO的封装，高性能，开源网络编程框架，提供异步的、基于事件驱动的网络应用程序框架和工具
## 架构
使用了典型的三层网络架构，Reactor 通信调度层 -> 职责链 PipeLine -> 业务逻辑处理层
Reactor层主要监听网络的读写和连接操作，负责将网络层的数据 读取到内存缓冲区中，然后触发各种网络事件，例如连接创建、连接激活、读事 件、写事件等等，将这些事件触发到 PipeLine 中，由 PipeLine 充当的职责链来 进行后续的处理
## 为什么选择Netty
1、API复杂
2、对多线程很熟悉：因为NIO涉及到Reactor模式
3、高可用的话：需要出路断连重连、半包读写、失败缓存等问题
4、JDK NIO的bug
拆包器
	https://zhuanlan.zhihu.com/p/415450910
	线程
## Netty抽象出两组线程池 BossGroup 专门负责接收客户端的连接, WorkerGroup 专门负责网络的读写；
BossGroup 和 WorkerGroup 类型都是 NioEventLoopGroup； NioEventLoopGroup 相当于一个事件循环组, 这个组中含有多个事件循环 ，每一个事件循环是 NioEventLoop；
NioEventLoop 表示一个不断循环的执行处理任务的线程， 每个NioEventLoop 都有一个selector , 用于监听绑定在其上的socket的网络通讯；