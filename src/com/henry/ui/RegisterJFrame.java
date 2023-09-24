package com.henry.ui;

import javax.swing.*;

public class RegisterJFrame extends JFrame {
    // 跟注册相关的逻辑都写在这个类中

    public RegisterJFrame() {
        this.setSize(488,500);
        this.setTitle("拼图注册界面");
        // 保持当前界面置顶 不然点击其他 会被挡住
        this.setAlwaysOnTop(true);
        // 保证当前窗口居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        this.setVisible(true);
    }
}
