package com.example.searchwithroomapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class SearchAdapter(contextt: Context, val layout: Int, val chapter: List<Chapter>) : ArrayAdapter<Chapter>(contextt, layout, chapter) {
    override fun getCount(): Int {
        return chapter.size
    }
    override fun getItem(position: Int): Chapter? {
        return chapter.get(position)
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var retView: View
        var vi = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        if (convertView == null) {
            retView = vi.inflate(layout, null)
        } else {
            retView = convertView
        }
        var chapterItem = getItem(position)
        val chapterName = retView.findViewById(R.id.tvSearch) as TextView
        chapterName.text = chapterItem!!.chapterName
        return retView
    }
}