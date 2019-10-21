package bank.repository;

import bank.model.BufferedImage;
import bank.model.Image;
import lombok.AccessLevel;
import lombok.Getter;

import javax.imageio.ImageIO;
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

This is an implementation of lazy, caching proxy and prototype patterns.
 */
public class ProxyFileImageRepository implements ImageRepository {

    private FileImageRepository fileImageRepository;

    public ProxyFileImageRepository() {
        fileImageRepository = new FileImageRepository();
    }

    // read all images and initialize cache only when it's first needed
    @Getter(lazy = true, value = AccessLevel.PRIVATE)
    private final Map<Path, Image> cache = cacheImages();

    private Map<Path, Image> cacheImages() {

        Map<Path, Image> cachedImages = new HashMap<>();
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
                            cachedImages.put(Path.of(img.getPath()), new BufferedImage(ImageIO.read(img)));
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
    public java.awt.image.BufferedImage load(Path path) throws IOException {
        if (getCache().containsKey(path)) {
            return (java.awt.image.BufferedImage) getCache()
                    .get(path)
                    .cloneImage()
                    .getImage();
        } else {
            BufferedImage image = new BufferedImage(fileImageRepository.load(path));
            getCache().put(path, image);
            return (java.awt.image.BufferedImage) image.cloneImage().getImage();
        }
    }

    @Override
    public java.awt.image.BufferedImage load(String imageName) throws IOException {
        Path path = Path.of(imageName);
        if (getCache().containsKey(path)) {
            return (java.awt.image.BufferedImage) getCache()
                    .get(path)
                    .cloneImage()
                    .getImage();
        } else {
            BufferedImage image = new BufferedImage(fileImageRepository.load(imageName));
            getCache().put(path, image);
            return (java.awt.image.BufferedImage) image.cloneImage().getImage();
        }
    }

    @Override
    public void save(java.awt.image.BufferedImage image, String format, Path path) throws IOException {
        fileImageRepository.save(image, format, path);
        getCache().put(path, new BufferedImage(image));
    }


}
