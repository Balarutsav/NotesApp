package com.utsav.notesapp.presentation.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.utsav.notesapp.data.NotesData


@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController(),
    homeViewModel: HomeViewModel, notes: List<NotesData> = listOf()
) {
    val notesList = remember {
        mutableStateListOf<NotesData>()
    }


    Scaffold(

        floatingActionButton = {
            FloatingActionButton(
                onClick = {


                    homeViewModel.addNote(
                        NotesData(
                            "note ${homeViewModel.notes.size + 1}",
                            homeViewModel.notes.size + 1
                        )
                    )
                    notesList.add(
                        NotesData(
                            "note ${homeViewModel.notes.size + 1}",
                            homeViewModel.notes.size + 1
                        )
                    )
                },
                content = {
                    Icon(Icons.Filled.Add, "", tint = Color.White)
                }
            )
        },
        content = {
//            setNotes(notes)

            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(items = notesList) {
                    NoteCard(note = it)
                }
            }
        }
    )


}

@Composable
fun setNotes(notes: List<NotesData>) {


}


@Composable
fun NoteCard(note: NotesData) {
    Text(text = note.note)
}






