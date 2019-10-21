package bank;

import bank.repository.FileImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.util.ResourceUtils;

import java.awt.image.BufferedImage;
import java.nio.file.Path;

@SpringBootApplication
@EnableAspectJAutoProxy
public class BankApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }

    @Autowired
    private FileImageRepository fileImageRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        BufferedImage image = fileImageRepository.load("logo.jpg");
        System.out.println(image.getHeight());
        System.out.println(image.getWidth());

        System.out.println();
        image = fileImageRepository.load(Path.of(ResourceUtils.getURL("classpath:").getPath(),
                "static", "wallpaper.jpg"));
        System.out.println(image.getHeight());
        System.out.println(image.getWidth());

        fileImageRepository.save(image, "jpg", Path.of(ResourceUtils
                .getURL("classpath:").getPath(), "static", "new_wallpaper.jpg"));
    }
}
