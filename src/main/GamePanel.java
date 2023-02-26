package main;

import entity.Player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    //JPanel work as a kind of game screen
    //SCREEN SETTING
    final int originalTileSize = 16; // default size of the player character, NPCs, gách trong bản đồ
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; // 48*48 kích thước từng viên gạch trong màn hình
    public final int maxScreencol = 16;//Có 16 ô gạch - 768
    public final int maxScreenrow = 16;//mỗi cột có 12 hàng gạch - 576
    public final int screenWidth = tileSize * maxScreencol; // chiều rộng screen
    public final int screenHeight = tileSize * maxScreenrow; // chiều dài

    int playerx = 100;
    int playery = 100;
    int playerspeed = 4;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread; // bạn có thể start và stop game
    int FPS = 60;

    Player player = new Player(this, keyH);
    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // để thiết lập kích thước cửa sổ.
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true); // gamepanel can be focused to recieve key input
    }
    public void startGameThread() {
        gameThread = new Thread(this); // this tham chiếu tới class GamePanel
        //Player player = new Player(this, keyH);
        gameThread.start(); // automaly call this run method
    }

    @Override
    public void run() {
        double drawInterval = 1000000000.0/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        while(gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/drawInterval;
            timer +=(currentTime - lastTime);
            lastTime = currentTime;
            System.out.println("delta: "+delta);

            if (delta>=1) {
                update();
                repaint(); // phuongw thuc goi ham paintComponent
                delta--;
            }
            if (timer>= 1000000000) {
                //System.out.println("FPS: "+ drawCount);
                timer = 0;
            }
        }
    }
    public void update() {
        player.update();
    }
    public void paintComponent(Graphics g) { // một công cụ để vẽ trong JPanel, Graphic là class chứa rất nhiều function để vẽ
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        player.draw(g2);
       // tạo hình chữ nhật và fill nó, xác định vị trí của nó;
        g2.dispose();
    }

}
