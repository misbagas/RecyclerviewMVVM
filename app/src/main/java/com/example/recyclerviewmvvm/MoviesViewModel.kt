package com.example.recyclerviewmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

class MoviesViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    private lateinit var job: Job

    private val _movies = MutableLiveData<List<Movie>>()
    val movie: LiveData<List<Movie>>
        get() = _movies

     fun getMovies() {

        job = Coroutines.ioThenMain(
            {
                repository.getMovie()
            },
            { _movies.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}
