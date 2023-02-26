package main;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//để nhấn nút button (x) sẽ thoát khỏi screen
        window.setResizable(false);//không thể resize
        window.setTitle("Squid Game"); //tên game

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();// window sẽ được sized để fit với kích thước và layout của game panel

        window.setLocationRelativeTo(null);// // sẽ xuất hiện ở giữa màn hình
        window.setVisible(true);//cách để hiển thị Screen
        //Mechanis of game 2D. Thì từ khi bắt đầu, game sẽ luôn chạy cho đến khi mình tắt hoặc làm gì đó đặc biệt
        gamePanel.startGameThread();
    }

}

