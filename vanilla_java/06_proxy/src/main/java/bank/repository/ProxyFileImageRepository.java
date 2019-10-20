package bank.repository;

import lombok.AccessLevel;
import lombok.Getter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;


/*
Proxy Pattern

Provide a surrogate or placeholder for another object to control access to it.
-GOF Design Patterns

The intent of this design pattern is to provide an alternate class for
another class , along with its functionality, to the outside world.

This is a implementation of lazy, caching proxy
 */
public class ProxyFileImageRepository implements ImageRepository {

    private FileImageRepository fileImageRepository;

    public ProxyFileImageRepository() {
        fileImageRepository = new FileImageRepository();
    }

    // read all images and initialize cache only when it's first needed
    @Getter(lazy = true, value = AccessLevel.PRIVATE)
    private final Map<Path, BufferedImage> cache = cacheImages();

    private Map<Path, BufferedImage> cacheImages() {

        Map<Path, BufferedImage> cachedImages = new HashMap<>();
        ClassLoader classLoader = getClass().getClassLoader();

        URL resourceURL = classLoader.getResource(".");
        if (resourceURL != null) {
            File resource = new File(resourceURL.getFile());
            String[] images = resource.list((file, s) -> // get only image files
                    s.endsWith(".png") || s.endsWith(".jpg") || s.endsWith(".gif"));
            if (images != null) {
                URL img;
                for (String image : images) {
                    try {
                        img = classLoader.getResource(image);
                        if (img != null) {
                            cachedImages.put(Path.of(img.getPath()), ImageIO.read(img));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return cachedImages;
    }

    @Override
    public BufferedImage load(Path path) throws IOException {
        if (getCache().containsKey(path)) {
            return getCache().get(path);
        } else {
            BufferedImage image = fileImageRepository.load(path);
            getCache().put(path, image);
            return image;
        }
    }

    @Override
    public BufferedImage load(String imageName) throws IOException {
        Path path = Path.of(imageName);
        if (getCache().containsKey(path)) {
            return getCache().get(path);
        } else {
            BufferedImage image = fileImageRepository.load(imageName);
            getCache().put(path, image);
            return image;
        }
    }

    @Override
    public void save(BufferedImage image, String format, Path path) throws IOException {
        fileImageRepository.save(image, format, path);
        getCache().put(path, image);
    }


}
