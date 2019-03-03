package com.note.keeper

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class NoteRecyclerAdapter(private val context: Context, private val notes: List<NoteInfo>) :
    RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create view to display each individual item
        val itemView = layoutInflater.inflate(R.layout.item_note_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.textCourse?.text = note.course?.courseTitle
        holder.textTitle?.text = note.noteTitle
        holder.notePosition = position
    }

    /**
     * must be inner in order to access the members of the containing NoteRecyclerAdapter class
     */
    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        // get reference to textView
        val textCourse = itemView?.findViewById<TextView?>(R.id.textCourse)
        val textTitle = itemView?.findViewById<TextView?>(R.id.textTitle)
        // handle user interaction
        var notePosition = 0

        init {
            itemView?.setOnClickListener {
                // ViewHolder must be inner class in order to have access to the context
                val intent = Intent(context, NoteActivity::class.java)
                intent.putExtra(NOTE_POSITION, notePosition)
                context.startActivity(intent)
            }
        }
    }

}