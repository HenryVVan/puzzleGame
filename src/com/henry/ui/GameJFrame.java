package com.henry.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener {
    // 规定GameJFrame 这个界面表示的就是游戏的主界面
    // 跟游戏相关的逻辑都写在这个类中
    int[][] data = new int[4][4];
    int[][] win = new int[4][4];
    int x, y;
    int step = 0; // 记录步数


    String path = "..\\puzzleGame\\image\\girl\\girl3\\";

    public GameJFrame() throws HeadlessException {
        // 设置界面宽、高

        // 初始化界面
        initJFrame();

        // 初始化菜单
        initJMenu();

        // 打乱顺序
        initData();

        // 初始化图片
        initImage();

        this.addKeyListener(this);

        this.setVisible(true);

    }

    private void initData() {
        // 打乱索引 (1 - 15)
        for (int i = 0; i < 16; i++) {
            data[i / 4][i % 4] = i;
            if (i != 15) win[i / 4][i % 4] = i + 1;
        }
        Random r = new Random();
        for (int i = 0; i < 16; i++) {
            int idx = r.nextInt(data.length);
            int t = data[idx / 4][idx % 4];
            data[idx / 4][idx % 4] = data[i / 4][i % 4];
            data[i / 4][i % 4] = t;
        }
        for (int i = 0; i < 16; i++) {
            if (data[i / 4][i % 4] == 0) {
                x = i / 4;
                y = i % 4;
            }
        }
/*        for (int i = 0; i < 16; i++) {
            System.out.println(data[i / 4][i % 4]);
        }*/
    }


    // 初始化图片
    private void initImage() {
        // 清空已经出现的所有图片
        this.getContentPane().removeAll();
        if (victory()) {
            JLabel winLabel = new JLabel(new ImageIcon("..\\puzzleGame\\image\\win.png"));
            winLabel.setBounds(203, 283, 197, 73);
            this.getContentPane().add(winLabel);
        }

        JLabel stepCount = new JLabel("步数" + step);
        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);

/*        // 创建一个图片 ImageIcon 对象
        ImageIcon imageIcon = new ImageIcon("D:\\Henry_work\\Code\\Java\\out\\puzzleGame\\image\\animal\\animal1\\2.jpg");
        // 创建一个JLabel对象 (管理容器)
        JLabel jLabel = new JLabel(imageIcon);
        // 指定图片位置
        jLabel.setBounds(0, 0, 105, 105);
*/
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
                // 左上角为原点，其他为坐标
                JLabel jLabel = new JLabel(new ImageIcon(path + num + ".jpg"));
                jLabel.setBounds(j * 105 + 83, i * 105 + 134, 105, 105);
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                this.getContentPane().add(jLabel);
            }
        }

        JLabel jLabelBG = new JLabel(new ImageIcon("..\\puzzleGame\\image\\background.png"));
        jLabelBG.setBounds(40, 40, 508, 560);
        this.getContentPane().add(jLabelBG);

        this.getContentPane().repaint();
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == 65) {
            this.getContentPane().removeAll();
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);
            JLabel jLabelBG = new JLabel(new ImageIcon("..\\puzzleGame\\image\\background.png"));
            jLabelBG.setBounds(40, 40, 508, 560);
            this.getContentPane().add(jLabelBG);
            // 刷新
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (victory()) return;

        int key = e.getKeyCode();
        // 左
        if (key == 37) {
            if (y <= 0) return;
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            step++;
        }
        // 上
        else if (key == 38) {
            if (x <= 0) return;
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            step++;
        }
        // 右
        else if (key == 39) {
            if (y >= 3) return;
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            step++;
        }
        // 下
        else if (key == 40) {
            if (x >= 3) return;
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            step++;
        } else if (key == 87) {
            for (int i = 0; i < 16; i++) {
                data[i / 4][i % 4] = i + 1;
                if (i == 15) {
                    data[i / 4][i % 4] = 0;
                }
            }
        }
        initImage();
    }

    // 判断是否胜利
    public boolean victory() {
        for (int i = 0; i < data.length; i++) {
            for (int i1 = 0; i1 < data[0].length; i1++) {
                if (data[i][i1] != win[i][i1]) return false;
            }
        }
        return true;
    }
}
