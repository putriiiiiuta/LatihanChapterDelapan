package putriiiiiuta.androidlima.latihanchapterdelapan.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import putriiiiiuta.androidlima.latihanchapterdelapan.repository.UserRepository
import putriiiiiuta.androidlima.latihanchapterdelapan.room.User
import javax.inject.Inject

@HiltViewModel
class ViewModelUser @Inject constructor(private val repository : UserRepository) : ViewModel() {
    var userLiveData: MutableLiveData<Int> = MutableLiveData()

    fun registerLive(user : User){
        viewModelScope.launch {
            repository.registerDao(user)
            delay(100)
        }

    }
    fun cekLoginLive(username : String, password : String){
        viewModelScope.launch {
            userLiveData.postValue(repository.cekLoginRepo(username,password))
            delay(100)

        }
    }

}