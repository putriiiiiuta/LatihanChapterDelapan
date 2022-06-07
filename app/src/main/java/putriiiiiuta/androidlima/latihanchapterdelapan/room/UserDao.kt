package putriiiiiuta.androidlima.latihanchapterdelapan.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun register(user : User) : Long

    @Query("SELECT EXISTS(SELECT * FROM User WHERE username = :username2 AND password = :password2) ")
    fun cekLogin(username2 : String, password2 : String) : Int

}