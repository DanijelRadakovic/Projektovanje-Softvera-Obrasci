package bank.repository;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

@Repository
public class FileImageRepository implements ImageRepository {

    @Override
    public BufferedImage load(Path path) throws IOException {
        return ImageIO.read(new FileInputStream(path.toString()));
    }

    @Override
    public BufferedImage load(String imageName) throws IOException {
        return ImageIO.read(ResourceUtils.getFile(Path.of("classpath:static", imageName).toString()));
    }

    @Override
    public void save(BufferedImage image, String format, Path path) throws IOException {
        ImageIO.write(image, format, path.toFile());
    }
}
