package com.henry.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class LoginJFrame extends JFrame implements MouseListener {
    // 跟登录相关的逻辑都写在这个类中
    static ArrayList<User> list = new ArrayList<>();
    static {
        list.add(new User("henry", "123"));
        list.add(new User("xinyu", "1234"));
    }

    JButton login = new JButton();
    JButton register = new JButton();
    JTextField username = new JTextField();
    JTextField password = new JTextField();
    JTextField code = new JTextField();
    String codeStr = CodeUtil.getCode();

    public LoginJFrame() {
        // 初始化界面
        initJFrame();

        // 为界面添加内容
        initView();


        this.setVisible(true);
    }

    private void initView() {
        // 添加用户名文字
        JLabel usernameText = new JLabel(new ImageIcon("..\\puzzleGame\\image\\login\\用户名.png"));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);

        // 添加用户名输入框

        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);

        // 添加密码文字
        JLabel passwordText = new JLabel(new ImageIcon("..\\puzzleGame\\image\\login\\密码.png"));
        passwordText.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordText);

        // 添加密码输入框

        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);

        // 添加验证码文本
        JLabel codeText = new JLabel(new ImageIcon("..\\puzzleGame\\image\\login\\验证码.png"));
        codeText.setBounds(133, 256, 50, 30);
        this.getContentPane().add(codeText);

        // 添加验证码输入框
        code.setBounds(195, 256, 100, 30);
        this.getContentPane().add(code);
        JLabel rightCode = new JLabel();
        rightCode.setText(codeStr);
        rightCode.setBounds(300, 256, 50, 30);
        this.getContentPane().add(rightCode);

        // 添加登录按钮
        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon("..\\puzzleGame\\image\\login\\登录按钮.png"));
        // 去除默认边框
        login.setBorderPainted(false);
        // 去除默认背景
        login.setContentAreaFilled(false);
        login.addMouseListener(this);
        this.getContentPane().add(login);



        // 添加注册按钮
        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("..\\puzzleGame\\image\\login\\注册按钮.png"));
        // 去除默认边框
        register.setBorderPainted(false);
        // 去除默认背景
        register.setContentAreaFilled(false);
        register.addMouseListener(this);
        this.getContentPane().add(register);


        // 添加背景图片
        JLabel bg = new JLabel(new ImageIcon("..\\puzzleGame\\image\\login\\background.png"));
        bg.setBounds(0, 0, 470, 390);
        this.getContentPane().add(bg);
    }

    private void initJFrame() {
        this.setSize(488, 430);
        this.setTitle("拼图登录界面");
        // 保持当前界面置顶 不然点击其他 会被挡住
        this.setAlwaysOnTop(true);
        // 保证当前窗口居中
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消默认居中
        this.setLayout(null);
    }

    public void showJDialog(String content) {
        // 创建弹窗对象
        JDialog jDialog = new JDialog();
        // 给弹窗设置大小
        jDialog.setSize(200,150);
        // 弹窗置顶
        jDialog.setAlwaysOnTop(true);
        // 弹窗居中
        jDialog.setLocationRelativeTo(null);
        // 不关闭弹窗无法进行下一步操作
        jDialog.setModal(true);

        // 创建JLabel对象 并交给弹窗管理
        JLabel warning = new JLabel(content);
        warning.setBounds(0,0,200,150);
        jDialog.getContentPane().add(warning);

        jDialog.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object obj = e.getSource();
        if (obj == login) {
            login.setIcon(new ImageIcon("..\\puzzleGame\\image\\login\\登录按下.png"));
//            this.getContentPane().add(login);
            login.repaint();
        }
        else if (obj == register) {
            register.setIcon(new ImageIcon("..\\puzzleGame\\image\\login\\注册按下.png"));
//            this.getContentPane().add(register);
            register.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object obj = e.getSource();
        if (obj == login) {
            String userName = username.getText();
            String passWord = password.getText();
            String rCode = code.getText();
            boolean flag = false;
            for (int i = 0; i < list.size(); i ++) {
                if (list.get(i).getName().equals(userName) && list.get(i).getPassword().equals(passWord)) {
                    flag = true;
                }
            }
            if (!rCode.equalsIgnoreCase(codeStr)) {
                showJDialog("验证码输入有误，请重新输入！");
            }
            else if (userName == null || passWord == null || userName.length() == 0 || passWord.length() == 0) {
                showJDialog("用户名或密码不能为空");
            }
            else if (!flag) {
                showJDialog("用户名或密码错误");
            }
            else if (flag) {
                this.setVisible(false);
                new GameJFrame();
            }
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
