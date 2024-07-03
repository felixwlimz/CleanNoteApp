package com.felix.cleannoteapp.core.domain.usecase

import com.felix.cleannoteapp.core.domain.usecase.note.DeleteNoteUseCase
import com.felix.cleannoteapp.core.domain.usecase.note.GetAllNotesUseCase
import com.felix.cleannoteapp.core.domain.usecase.note.GetNoteUseCase
import com.felix.cleannoteapp.core.domain.usecase.note.InsertNoteUseCase
import com.felix.cleannoteapp.core.domain.usecase.note.UpdateNoteUseCase

data class NoteUseCase(
    val getAllNotes: GetAllNotesUseCase,
    val deleteNote: DeleteNoteUseCase,
    val insertNote: InsertNoteUseCase,
    val updateNote: UpdateNoteUseCase,
    val getNote : GetNoteUseCase
)
