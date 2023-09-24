package com.henry.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    // 跟登录相关的逻辑都写在这个类中

    public LoginJFrame() {
        this.setSize(488,430);
        this.setTitle("拼图登录界面");
        // 保持当前界面置顶 不然点击其他 会被挡住
        this.setAlwaysOnTop(true);
        // 保证当前窗口居中
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        this.setVisible(true);
    }

}
