package com.utsav.notesapp.presentation.home

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.utsav.notesapp.data.NotesData

class HomeViewModel : ViewModel() {
    fun addNote(notesData: NotesData) {
         notes.add(notesData)
    }

    var notes = mutableStateListOf<NotesData>()

    init {
        notes.add(NotesData("note 1", 0))
    }
}