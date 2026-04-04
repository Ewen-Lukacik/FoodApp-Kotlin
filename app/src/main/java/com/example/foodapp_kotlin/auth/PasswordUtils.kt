package com.example.foodapp_kotlin.auth

import java.security.MessageDigest
import java.security.SecureRandom

object PasswordUtils {

    fun generateSalt(): String {
        val bytes = ByteArray(16)
        SecureRandom().nextBytes(bytes)
        return bytes.joinToString("") { "%02x".format(it) }
    }

    fun hashPassword(password: String, salt: String): String {
        val input = salt + password
        val digest = MessageDigest.getInstance("SHA-256")
        val hashBytes = digest.digest(input.toByteArray(Charsets.UTF_8))
        return hashBytes.joinToString("") { "%02x".format(it) }
    }

    fun verify(password: String, salt: String, storedHash: String): Boolean {
        return hashPassword(password, salt) == storedHash
    }
}
