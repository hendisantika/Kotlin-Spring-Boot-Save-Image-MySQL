package com.hendisantika.KotlinSpringBootSaveImageMySQL

import com.hendisantika.KotlinSpringBootSaveImageMySQL.model.ImageModel
import com.hendisantika.KotlinSpringBootSaveImageMySQL.repository.ImageRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.io.ClassPathResource
import java.nio.file.Files
import java.nio.file.Paths

@SpringBootApplication
class KotlinSpringBootSaveImageMySqlApplication {
    @Bean
    fun imageProcess(imageRepository: ImageRepository) = CommandLineRunner {
        // image 1
        val backImgFile = ClassPathResource("image/Angular.png")
        var arrayPic = ByteArray(backImgFile.contentLength().toInt())
        backImgFile.inputStream.read(arrayPic)
        val blackImage = ImageModel(1, "Angular", "png", arrayPic)

        // image 2
        val blueImgFile = ClassPathResource("image/boot.png")
        arrayPic = ByteArray(blueImgFile.contentLength().toInt())
        blueImgFile.inputStream.read(arrayPic)
        val blueImage = ImageModel(2, "boot", "png", arrayPic)

        // store image to MySQL via SpringJPA
        imageRepository.save(blackImage)
        imageRepository.save(blueImage)

        // retrieve image from MySQL via SpringJPA
        imageRepository.findAll().forEach { imageModel ->
            Files.write(Paths.get("retrieve-dir/" + imageModel.name + "." + imageModel.type), imageModel.pic)
        }
    }
}

fun main(args: Array<String>) {
    runApplication<KotlinSpringBootSaveImageMySqlApplication>(*args)
}
