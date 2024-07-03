package com.felix.cleannoteapp.core.domain.usecase.note

import com.felix.cleannoteapp.core.domain.model.Note
import com.felix.cleannoteapp.core.repository.INoteRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class InsertNoteUseCase(private val noteRepository: INoteRepository) {

    operator fun invoke(note : Note) : Single<Int> {
        return noteRepository.insertNote(note)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

}