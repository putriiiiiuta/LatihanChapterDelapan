package putriiiiiuta.androidlima.latihanchapterdelapan.datastore

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserManager(context : Context) {
    // dua data store, data user dan data status user
    private val dataStore : DataStore<Preferences> = context.createDataStore(name = "user_prefs2")
    private val dataStore2 : DataStore<Preferences> = context.createDataStore(name = "status")


    companion object {
        //object data
        val USERNAME = preferencesKey<String>("USERNAME")
        val PASSWORD = preferencesKey<String>("PASSWORD")

        val STATUS = preferencesKey<String>("STATUS")


    }
    //fungsi login insert data ke datastore
    suspend fun login( username : String, password : String){
        dataStore.edit {
            it[USERNAME] = username
            it[PASSWORD] = password

        }
    }


    //status user di datastore2 (sebagai pengecekan auth)
    suspend fun setStatus(status : String){
        dataStore2.edit {
            it[STATUS] = status
        }
    }

    val userSTATUS : Flow<String> = dataStore2.data.map {
        it[STATUS] ?: "no"
    }
}