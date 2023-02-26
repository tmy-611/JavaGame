package entity;

import java.awt.image.BufferedImage;

public class Entity {
    public int x, y;
    public int speed;

    public BufferedImage up1, up2, up3, stand, down1, down2, left1, left2, right1, right2;
    //Mô tả hình ảnh dưới dạng một thông tin (để lưu trữ file ảnh))

    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

}
