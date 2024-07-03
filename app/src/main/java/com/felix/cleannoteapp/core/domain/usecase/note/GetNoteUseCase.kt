package com.felix.cleannoteapp.core.domain.usecase.note

import com.felix.cleannoteapp.core.domain.model.Note
import com.felix.cleannoteapp.core.repository.INoteRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers

class GetNoteUseCase(private val noteRepository: INoteRepository) {

    operator fun invoke(id : Int) : Flowable<Note> {
        return noteRepository.getNoteById(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }


}