package com.utsav.notesapp.presentation.home

import android.util.Log
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
import androidx.compose.runtime.snapshots.SnapshotStateList
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
                    Log.e("home view model list", "MainScreen: ${homeViewModel.notes.size}")

                },
                content = {
                    Icon(Icons.Filled.Add, "", tint = Color.White)
                }
            )
        },
        content = {
            setNotes(notes = homeViewModel.notes)
        }
    )


}

@Composable
fun setNotes(notes: SnapshotStateList<NotesData>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(items = notes, key = { listItem ->
            listItem.id // or any other unique
        }) {
            NoteCard(note = it)
        }
    }

}


@Composable
fun NoteCard(note: NotesData) {
    Text(text = note.note)
}






