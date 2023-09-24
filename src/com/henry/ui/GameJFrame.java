package com.henry.ui;

import javax.swing.*;
import java.awt.*;

public class GameJFrame extends JFrame {
    // 规定GameJFrame 这个界面表示的就是游戏的主界面
    // 跟游戏相关的逻辑都写在这个类中

    public GameJFrame() throws HeadlessException {
        // 设置界面宽、高

        initJFrame();

        initJMenu();

        this.setVisible(true);

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

        // 设置关闭模式 设置为2的话，需要同时在每个JFrame中设置，然后关闭所有的窗口 之后 会退出程序
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
