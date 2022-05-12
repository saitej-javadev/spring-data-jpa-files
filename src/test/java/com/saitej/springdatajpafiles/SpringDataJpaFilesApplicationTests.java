package com.saitej.springdatajpafiles;

import com.saitej.springdatajpafiles.entities.Image;
import com.saitej.springdatajpafiles.repos.ImageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@SpringBootTest
class SpringDataJpaFilesApplicationTests {

    @Autowired
    private ImageRepository imageRepository;

    @Test
    void testImageSave() throws IOException {
        Image image = new Image();
        image.setId(1L);
        image.setName("react-img.JPG");
        File file = new File("E:\\images\\react-img.jpg");
        byte[] bytes = new byte[(int) file.length()];
        FileInputStream inputStream = new FileInputStream(file);
        inputStream.read(bytes);

        image.setData(bytes);
        imageRepository.save(image);
        inputStream.close();
    }


    @Test
    void testImageRead() {

        Image image = imageRepository.findById(1L).get();
        
        File file = new File("E:\\images\\downloaded\\" + image.getName());

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(image.getData());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
