package com.felix.cleannoteapp.presentation.home

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.felix.cleannoteapp.core.domain.model.Note
import com.felix.cleannoteapp.core.domain.usecase.NoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@SuppressLint("CheckResult")
@HiltViewModel
class HomeViewModel @Inject constructor(private val noteUseCase: NoteUseCase) : ViewModel(){

    private val _notes : MutableLiveData<List<Note>> = MutableLiveData()
    val notes : LiveData<List<Note>> = _notes

    fun getAllNotes() {
        noteUseCase.getAllNotes.invoke().subscribe({
            _notes.value = it
        }, {
            it.printStackTrace()
        })
    }

}