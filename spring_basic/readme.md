2023.6.26（修改了maven.conf的mirror配置，不然那aliyun 无法下载springboot admin，要 记得改回去）
引入了 SpringBoot actuator，进行了简单的整合
在8092 端口下，开启了actuator
引入了 SpringBoot admin，进行了简单的整合
仍然以8092作为admin客户端，以8093作为admin服务端来显示监控的信息。
在admin服务端的启动类上需要加上@EnableAdminServer注解
配置信息如application.yml下所示
当然，如果是生产情况下，一般是一台机器监控另一台机器，而不是自己监控自己的另一个端口哦