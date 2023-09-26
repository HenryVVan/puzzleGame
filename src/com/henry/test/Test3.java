package com.henry.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test3 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(603, 608);
        jFrame.setTitle("事件演示");
        jFrame.setAlwaysOnTop(true);
        // 设置界面居中
        jFrame.setLocationRelativeTo(null);
        // 设置关闭模式
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLayout(null);

        JButton jtb = new JButton("touch me");
        jtb.setBounds(0, 0, 100, 50);

//        jtb.addActionListener(new MyActionListener());
        jtb.addActionListener(new ActionListener() {
                                  @Override
                                  public void actionPerformed(ActionEvent e) {
                                      System.out.println("按钮被按下了");
                                  }
                              }

        );

        jFrame.getContentPane().add(jtb);

        jFrame.setVisible(true);
    }
}
