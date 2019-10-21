package bank.repository;

import bank.domain.BufferedImage;
import bank.domain.Image;
import lombok.AccessLevel;
import lombok.Getter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
@Aspect
@Component
public class ProxyFileImageRepository {

    // read all images and initialize cache only when it's first needed
    @Getter(lazy = true, value = AccessLevel.PRIVATE)
    private final Map<Path, Image> cache = cacheImages();

    private Map<Path, Image> cacheImages() {

        Map<Path, Image> cachedImages = new HashMap<>();

        try {
            File staticFolder = ResourceUtils.getFile("classpath:static");
            Path imagePath;

            String[] images = staticFolder.list((file, s) -> // get only image files
                    s.endsWith(".png") || s.endsWith(".jpg") || s.endsWith(".gif"));
            if (images != null) {
                for (String image : images) {
                    try {
                        imagePath = Path.of(staticFolder.getPath(), image);
                        cachedImages.put(imagePath, new BufferedImage(ImageIO
                                .read(new FileInputStream(imagePath.toString()))));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cachedImages;
    }

    @Around("execution(* bank.repository.FileImageRepository.load(..)) && args(parameter)")
    public java.awt.image.BufferedImage aroundLoad(ProceedingJoinPoint joinPoint, Object parameter) throws IOException {
        Path path;
        try {
            // FileImageRepository.load(Path path) method is intercepted
            path = (Path) parameter;
        } catch (ClassCastException e) {
            // FileImageRepository.load(String imageName) method is intercepted
            path = Path.of(ResourceUtils.getFile("classpath:static").getPath(), (String) parameter);
        }

        if (getCache().containsKey(path)) {
            return (java.awt.image.BufferedImage) getCache()
                    .get(path)
                    .cloneImage()
                    .getImage();
        } else {
            try {
                // joinPoint.proceed() executes FileImageRepository.load(...) method
                BufferedImage image = new BufferedImage((java.awt.image.BufferedImage) joinPoint.proceed());
                getCache().put(path, image);
                return (java.awt.image.BufferedImage) image.cloneImage().getImage();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            return null;
        }
    }


    @Around("execution(* bank.repository.FileImageRepository.save(..)) && args(image, format, path)")
    public void aroundSave(ProceedingJoinPoint joinPoint, java.awt.image.BufferedImage image, String format, Path path)
            throws IOException {
        try {
            // joinPoint.proceed() executes FileImageRepository.save(...) method
            joinPoint.proceed(new Object[]{image, format, path});
            getCache().put(path, new BufferedImage(image));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


}
