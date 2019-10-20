package bank.repository;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

public class FileImageRepository implements ImageRepository {

    @Override
    public BufferedImage load(Path path) throws IOException {
        return ImageIO.read(new FileInputStream(path.toString()));
    }

    @Override
    public BufferedImage load(String imageName) throws IOException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(imageName);
        if (stream != null) {
            return ImageIO.read(stream);
        }
        return null;
    }

    @Override
    public void save(BufferedImage image, String format, Path path) throws IOException {
        ImageIO.write(image, format, path.toFile());
    }
}
