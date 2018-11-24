package com.hendisantika.KotlinSpringBootSaveImageMySQL.model

import javax.persistence.*

/**
 * Created by IntelliJ IDEA.
 * Project : Kotlin-Spring-Boot-Save-Image-MySQL
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2018-11-23
 * Time: 06:32
 */
@Entity
@Table(name = "image_model")
data class ImageModel(
        @Id
        @Column(name = "id")
        val id: Long,

        @Column(name = "name")
        val name: String,

        @Column(name = "type")
        val type: String,

        @Lob
        @Column(name = "pic")
        val pic: ByteArray
) {
    private constructor() : this(-1, "", "", byteArrayOf())
}