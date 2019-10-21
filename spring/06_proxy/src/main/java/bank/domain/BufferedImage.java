package bank.domain;

import java.awt.image.ColorModel;

public class BufferedImage extends Image {

    public BufferedImage() {
    }

    public BufferedImage(java.awt.image.BufferedImage image) {
        this.image = image;
    }

    @Override
    public Image cloneImage() {
        BufferedImage clone = null;
        try {
            clone = (BufferedImage) super.clone(); // shallow copy
            java.awt.image.BufferedImage cloneImage = (java.awt.image.BufferedImage) clone.image;
            ColorModel cm = cloneImage.getColorModel();
            clone.image = new java.awt.image.BufferedImage(
                    cm, cloneImage.copyData(null),
                    cm.isAlphaPremultiplied(), null
            );
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
