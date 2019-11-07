package com.dean.moviecatalogdean

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.item_movie.view.*
import java.security.AccessControlContext

class MovieAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var movies = arrayListOf<Movie>()

    override fun getView(p0: Int, p1: View?, p2: ViewGroup): View {
        var itemView = p1
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, p2, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val movie = getItem(p0) as Movie
        viewHolder.bind(movie)
        return itemView
    }

    override fun getItem(p0: Int): Any = movies[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getCount(): Int = movies.size

}

private class ViewHolder constructor(
    private val view: View) {

    private val textTitleMovie: TextView = view.tv_title_movie
    private val textDescriptionMovie: TextView = view.tv_description_movie
    private val imagePoster: ImageView = view.img_view_movie

    internal fun bind(movie: Movie) {
        textTitleMovie.text = movie.title
        textDescriptionMovie.text = movie.description
        imagePoster.setImageResource(movie.image)
    }

}
