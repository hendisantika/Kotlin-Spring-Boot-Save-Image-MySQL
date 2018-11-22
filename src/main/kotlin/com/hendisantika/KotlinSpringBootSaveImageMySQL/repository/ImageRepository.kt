package com.hendisantika.KotlinSpringBootSaveImageMySQL.repository

import com.hendisantika.KotlinSpringBootSaveImageMySQL.model.ImageModel

/**
 * Created by IntelliJ IDEA.
 * Project : Kotlin-Spring-Boot-Save-Image-MySQL
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2018-11-23
 * Time: 06:33
 */
interface ImageRepository : JpaRepository<ImageModel, Long>