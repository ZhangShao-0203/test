package com.zhangshao.tools;

import cn.hutool.core.util.NetUtil;

import javax.swing.*;

public class tools {
    public static void main(String[] args) {
        checkServer();
    }

    public static void checkServer() {
        if (NetUtil.isUsableLocalPort(8161)) {
            JOptionPane.showMessageDialog(null, "ActiveMQ 服务器未启动 ");
            System.exit(1);
        }
    }
}
