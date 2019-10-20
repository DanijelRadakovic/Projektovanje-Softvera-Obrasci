package bank;

import bank.repository.ProxyFileImageRepository;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class BankApplication {

    public static void main(String[] args) {

        String[] imageNames = {"default_avatar.png", "logo.jpg", "wallpaper.jpg"};
        ProxyFileImageRepository proxy = new ProxyFileImageRepository();
        BufferedImage image;

        try {
            for (String imageName : imageNames) {
                image = proxy.load(imageName);
                System.out.println(imageName);
                System.out.println("Height: " + image.getHeight());
                System.out.println("Width: " + image.getWidth());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
