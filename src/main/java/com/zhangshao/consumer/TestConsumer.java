package com.zhangshao.consumer;

import cn.hutool.core.util.RandomUtil;
import com.zhangshao.tools.tools;
import lombok.SneakyThrows;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class TestConsumer {
    //服务地址
    private static final String url = "tcp://127.0.0.1:61616";
    //发送的名字
    private static final String topicName = "queue_style";
    //消费者可能有多个,为了区分不同的消费者,创建随机消费者
    private static final String consumerName="consumer-" + RandomUtil.randomString(5);
    public static void main(final String[] args) throws JMSException {
        //0.先判断端口是否启动 ActiveMQ 服务器
        tools.checkServer();
        //1.创建ConnectionFactory,绑定地址
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(url);
        //2.创建Connection
        Connection connection = activeMQConnectionFactory.createConnection();
        //3.启动连接
        connection.start();
        //4.创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5.创建一个目标 (队列类型)
//        Queue queue = session.createQueue(topicName);
        Destination destination=session.createQueue(topicName);
        //6.创建一个生产者
        MessageConsumer consumer = session.createConsumer(destination);
        //7.创建消息
        consumer.setMessageListener(new MessageListener() {
            @SneakyThrows
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage)message;
                System.out.println(consumerName+"接受的消息"+textMessage.getText());
            }
        });
        //8.  因为不知道什么时候有,所以不关闭,处于监听状态
//        connection.close();
    }
}
