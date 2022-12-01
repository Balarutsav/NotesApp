package com.utsav.notesapp.presentation.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp

import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.utsav.notesapp.R
import com.utsav.notesapp.data.NotesData
import com.utsav.notesapp.navigation.Note
import kotlin.random.Random


@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController(),
    homeViewModel: HomeViewModel, notes:List<NotesData> = listOf()
) {

    val notes= remember {
        notes
    }

    Scaffold(

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    homeViewModel.addNote(NotesData("note ${notes.size + 1}"))
                },
                content = {
                    Icon(Icons.Filled.Add, "", tint = Color.White)
                }
            )
        },
        content = {
            setNotes(notes)
        }
    )


}
@Composable
fun setNotes(notes: List<NotesData>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(items = notes, key = { it.note }) {
            NoteCard(note = it)
        }
    }
}


@Composable
fun NoteCard(note: NotesData) {
    Text(text = note.note)
}




