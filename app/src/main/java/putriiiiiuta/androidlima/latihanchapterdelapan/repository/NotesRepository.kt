package putriiiiiuta.androidlima.latihanchapterdelapan.repository

import putriiiiiuta.androidlima.latihanchapterdelapan.room.Notes
import putriiiiiuta.androidlima.latihanchapterdelapan.room.NotesDao
import javax.inject.Inject

class NotesRepository @Inject constructor(private val dao : NotesDao) {
    fun getAllNotes() : List<Notes>{
        return dao.getNotes()
    }

    fun insertNote(note : Notes){
        dao.insertNote(note)

    }
}