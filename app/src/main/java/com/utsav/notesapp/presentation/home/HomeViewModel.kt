package com.utsav.notesapp.presentation.home

import androidx.lifecycle.ViewModel
import com.utsav.notesapp.data.NotesData

class HomeViewModel : ViewModel() {
    fun addNote(notesData: NotesData): List<NotesData> {
        notes = notes + listOf(notesData)
        return notes
    }

    var notes = listOf<NotesData>()

    init {
       notes = notes + listOf(NotesData("note 1", 0))
    }
}