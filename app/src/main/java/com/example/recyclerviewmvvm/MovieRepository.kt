package com.example.recyclerviewmvvm

class MovieRepository(
    private val api: MoviesApi
) : SafeApiRequest() {
    suspend fun getMovie() = apiRequest { api.getMovies() }
}