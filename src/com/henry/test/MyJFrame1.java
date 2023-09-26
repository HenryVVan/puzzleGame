package com.henry.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame1 extends JFrame implements MouseListener {
    JButton jtb = new JButton("鼠标触发");
    public MyJFrame1() throws HeadlessException {
        this.setSize(600, 600);
        this.setTitle("鼠标触发测试");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);

        this.setLayout(null); // 取消默认居中设置

        jtb.setBounds(0, 0, 100, 50);

        jtb.addMouseListener(this);

        this.getContentPane().add(jtb);

        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("鼠标单击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("鼠标按下");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("鼠标松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("鼠标划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("鼠标划出");
    }
}
