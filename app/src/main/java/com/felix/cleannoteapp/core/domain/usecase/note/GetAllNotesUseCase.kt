package com.felix.cleannoteapp.core.domain.usecase.note

import com.felix.cleannoteapp.core.domain.model.Note
import com.felix.cleannoteapp.core.repository.INoteRepository
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers


class GetAllNotesUseCase(private val noteRepository: INoteRepository) {

    operator fun invoke() : Flowable<List<Note>> {
        return noteRepository.getAllNotes()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}