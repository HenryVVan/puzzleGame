package com.henry.ui;

import javax.swing.*;
import java.awt.*;

public class GameJFrame extends JFrame {
    // 规定GameJFrame 这个界面表示的就是游戏的主界面
    // 跟游戏相关的逻辑都写在这个类中

    public GameJFrame() throws HeadlessException {
        // 设置界面宽、高

        // 初始化界面
        initJFrame();

        // 初始化菜单
        initJMenu();

        // 初始化图片
        initImage();


        this.setVisible(true);

    }

    private void initImage() {
        // 初始化图片

/*        // 创建一个图片 ImageIcon 对象
        ImageIcon imageIcon = new ImageIcon("D:\\Henry_work\\Code\\Java\\out\\puzzleGame\\image\\animal\\animal1\\2.jpg");
        // 创建一个JLabel对象 (管理容器)
        JLabel jLabel = new JLabel(imageIcon);
        // 指定图片位置
        jLabel.setBounds(0, 0, 105, 105);*/

        for (int i = 0; i < 4; i ++) {
            for (int j = 0; j < 4; j ++) {
                if (i == 3 && j == 3) break;
                // 左上角为原点，其他为坐标
                JLabel jLabel = new JLabel(new ImageIcon("D:\\Henry_work\\Code\\Java\\out\\puzzleGame\\image\\animal\\animal1\\" + (i * 4 + j + 1) + ".jpg"));
                jLabel.setBounds(j * 105, i * 105, 105, 105);
                this.getContentPane().add(jLabel);
            }
        }

        // 把管理容器添加到界面中
        // this.add(jLabel);
        // this.getContentPane().add(jLabel);
    }



    private void initJMenu() {
        // 初始化菜单
        // 创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        // 创建菜单上面的两个选项的对象
        JMenu functionjMenu = new JMenu("功能");
        JMenu aboutjMenu = new JMenu("关于我们");

        // 创建选项下面的条目对象
        JMenuItem rePlayItem = new JMenuItem("再玩一局");
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem = new JMenuItem("公众号");

        // 将条目加到对应的选项中
        functionjMenu.add(rePlayItem);
        functionjMenu.add(reLoginItem);
        functionjMenu.add(closeItem);

        aboutjMenu.add(accountItem);

        // 将选项加入到菜单对象中
        jMenuBar.add(functionjMenu);
        jMenuBar.add(aboutjMenu);

        // 给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        this.setSize(603, 680);
        this.setTitle("拼图单机版");
        // 保持当前界面置顶 不然点击其他 会被挡住
        this.setAlwaysOnTop(true);
        // 保证当前窗口居中
        this.setLocationRelativeTo(null);

        // 取消JFrame容器中默认的居中方式，只有取消了设置的其他管理容器才会按X Y放置
        this.setLayout(null);

        // 设置关闭模式 设置为2的话，需要同时在每个JFrame中设置，然后关闭所有的窗口 之后 会退出程序
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
