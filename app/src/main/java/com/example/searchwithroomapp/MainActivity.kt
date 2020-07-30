package com.example.searchwithroomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var chapterDatabase: ChapterDatabase? = null
    private lateinit var searchView:SearchView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chapterDatabase = ChapterDatabase.getDatabase(this)!!
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_view, menu)
        val searchItem = menu!!.findItem(R.id.action_search)
        searchView = searchItem.actionView as SearchView
        searchView.setSubmitButtonEnabled(true)
        searchView.setQueryHint("Search either - MindOrks, GetMeAnApp, BestContentApp, Hackerspace")
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                getNamesFromDb(newText)
                return true
            }
            override fun onQueryTextSubmit(query: String): Boolean {
                getNamesFromDb(query)
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
    private fun getNamesFromDb(searchText: String) {
        val searchTextQuery = "%$searchText%"
        chapterDatabase!!.chapterDao().getChapterName(searchTextQuery)
            .observe(this, object : Observer<List<Chapter>> {
                override fun onChanged(chapter: List<Chapter>?) {
                    if (chapter == null) {
                        return
                    }
                    val adapter = SearchAdapter(
                        this@MainActivity,
                        R.layout.list_item,
                        chapter
                    )
                    lvSearchResult.adapter = adapter
                }
            })
    }
}
