package putriiiiiuta.androidlima.latihanchapterdelapan.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import putriiiiiuta.androidlima.latihanchapterdelapan.repository.NotesRepository
import putriiiiiuta.androidlima.latihanchapterdelapan.room.Notes
import javax.inject.Inject

@HiltViewModel
class ViewModelNotes @Inject constructor(private val repository : NotesRepository) : ViewModel() {
    var noteLiveData: MutableLiveData<List<Notes>> = MutableLiveData()


    private fun getAllFavLive(){
        viewModelScope.launch {
            val list = repository.getAllNotes()
            delay(100)
            noteLiveData.postValue(list)
        }
    }

    fun insertNoteLive(note : Notes){
        viewModelScope.launch {
            repository.insertNote(note)
            delay(2000)
            getAllFavLive()
        }

    }

}