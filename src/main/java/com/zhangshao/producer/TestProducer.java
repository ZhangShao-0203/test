package com.zhangshao.producer;

import com.zhangshao.tools.tools;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class TestProducer {
    //服务地址
    private static final String url = "tcp://127.0.0.1:61616";
    //发送的名字
    private static final String topicName = "queue_style";
    public static void main(String[] args) {
        //0. 先判断端口是否启动了  Active MQ 服务器
        tools.checkServer();
        //1.创建ConnectionFactory,绑定地址
        ConnectionFactory factory=new ActiveMQConnectionFactory(url);
        //2.创建Connection
        //3.启动连接
        //4.创建会话
        //5.创建一个目标 (队列类型)
        //6.创建一个生产者
        //7.创建消息
        // 8.发送消息
        //9. 关闭连接
    }
}
