package bank.repository;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

public interface ImageRepository {

    BufferedImage load(Path path) throws IOException;

    BufferedImage load(String imageName) throws IOException;

    void save(BufferedImage image, String format, Path path) throws IOException;
}
