package the.flash.client.console;

import io.netty.channel.Channel;

import java.util.Scanner;
/**
 * 定义命令，可以在控制台实现各个功能
 * 比如输入，"sendToUser"，就可以发送消息
 */
public interface ConsoleCommand {
    void exec(Scanner scanner, Channel channel);
}
