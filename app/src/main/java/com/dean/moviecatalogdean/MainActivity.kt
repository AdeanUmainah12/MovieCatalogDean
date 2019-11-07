package com.dean.moviecatalogdean

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var adapter: MovieAdapter
    private lateinit var movieName: Array<String>
    private lateinit var movieDescription: Array<String>
    private lateinit var movieYear: Array<String>
    private lateinit var movieImage: TypedArray
    private var movies = arrayListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MovieAdapter(this)
        list_movie.adapter = adapter

        dataMovie()
        addItemMovie()

        list_movie.onItemClickListener = AdapterView.OnItemClickListener { _, _, p0, _ ->
            val intentMovie = Intent(this, DetailActivity::class.java)
            intentMovie.putExtra(EXTRA_MOVIE, movies[p0])
            startActivity(intentMovie)
        }
    }

    private fun addItemMovie() {
        for (p0 in movieName.indices) {
            val movie = Movie(
                p0, movieName[p0],
                movieDescription[p0],
                movieYear[p0],
                movieImage.getResourceId(p0, -1)
            )
            movies.add(movie)
        }
        adapter.movies = movies
    }

    private fun dataMovie() {
        movieName = resources.getStringArray(R.array.movie_names)
        movieDescription = resources.getStringArray(R.array.movie_descriptions)
        movieYear = resources.getStringArray(R.array.movie_years)
        movieImage = resources.obtainTypedArray(R.array.movie_image)
    }
}
