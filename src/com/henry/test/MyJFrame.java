package com.henry.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener {

    JButton jtb1 = new JButton("1");
    JButton jtb2 = new JButton("2");

    public MyJFrame() throws HeadlessException {
        this.setSize(600, 600);
        this.setTitle("按钮触发测试");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);

        this.setLayout(null); // 取消默认居中设置

        jtb1.setBounds(0, 0, 100, 50);
        jtb1.addActionListener(this);
        jtb2.setBounds(100, 0, 100, 50);
        jtb2.addActionListener(this);

        this.getContentPane().add(jtb1);
        this.getContentPane().add(jtb2);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o == jtb1) {
            jtb1.setSize(150, 100);
        } else if (o == jtb2) {
            Random r = new Random();
            jtb2.setLocation(r.nextInt(400), r.nextInt(300));
        }
    }
}
