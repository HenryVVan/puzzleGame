package com.henry.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame2 extends JFrame implements KeyListener {
    JButton jtb = new JButton("键盘触发");

    public MyJFrame2() throws HeadlessException {
        this.setSize(600,600);
        this.setTitle("键盘触发测试");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);

        jtb.setBounds(0,0,100,50);
        jtb.addKeyListener(this);
        this.getContentPane().add(jtb);

        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("键盘被按下");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int val = e.getKeyCode();
        if (val == 65) {
            System.out.println("按下的是A");
        }
        else if (val == 66) {
            System.out.println("按下的是B");
        }
    }
}
