package putriiiiiuta.androidlima.latihanchapterdelapan.repository

import putriiiiiuta.androidlima.latihanchapterdelapan.room.User
import putriiiiiuta.androidlima.latihanchapterdelapan.room.UserDao
import javax.inject.Inject

class UserRepository @Inject constructor(private val dao : UserDao) {

    fun registerDao(user : User){
        dao.register(user)
    }
    fun cekLoginRepo(user : String, password : String) : Int{
        return dao.cekLogin(user, password)
    }
}