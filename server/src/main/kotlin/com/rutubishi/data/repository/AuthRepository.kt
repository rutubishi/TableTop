package com.rutubishi.data.repository

import com.rutubishi.data.db.User
import com.rutubishi.data.db.Users
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.or

interface AuthRepository {
    @Throws(Exception::class)
    fun createUser(
        name: String,
        email: String,
        phone: String,
        password: String
    ): User?
    @Throws(Exception::class)
    fun findUserByIdOrEmail(
        id: Long? = null,
        email: String? = null): User?
}

class AuthRepoImpl(appDB: Database):
    BaseRepository(appDB), AuthRepository {
    override fun createUser(name: String, email: String, phone: String, password: String): User? {
        var user: User? = null
        dbQuery {
            user = User.new {
                this.email = email
                this.name = name
                this.phone = phone
                this.passwordHash = password
            }
        }
        return user
    }

    override fun findUserByIdOrEmail(id: Long?, email: String?): User? {
        return if(id == null && email == null) null
        else {
            var user: User? = null
            dbQuery {
                user = User
                    .find { (Users.email eq (email?: "")) or (Users.id eq (id?: 0))  }
                    .limit(n = 1)
                    .firstOrNull()
            }
            user
        }

    }

}