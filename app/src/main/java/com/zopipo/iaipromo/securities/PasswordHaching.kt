package com.zopipo.iaipromo.securities
import org.mindrot.jbcrypt.BCrypt

class PasswordHaching {

    fun hashPasswordWithBCrypt(password: String): String {
        return BCrypt.hashpw(password, BCrypt.gensalt())
    }

    fun verifyPassword(plainPassword: String, hashedPassword: String): Boolean {
        return BCrypt.checkpw(plainPassword, hashedPassword)
    }
}