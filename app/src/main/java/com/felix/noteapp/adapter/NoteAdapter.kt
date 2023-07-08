package com.felix.noteapp.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.felix.noteapp.R
import com.felix.noteapp.core.domain.data.Notes
import com.felix.noteapp.databinding.NoteCardBinding

class NoteAdapter(private val notes : ArrayList<Notes>): RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    var onItemClickListener : OnItemClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = NoteCardBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    override fun getItemCount(): Int = notes.size

    inner class ViewHolder(private val binding : NoteCardBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(note : Notes){
            binding.apply {
                noteTitle.text = note.title
                noteDescription.text = note.description
                noteCard.setOnClickListener {
                    val bundle = Bundle()
                    bundle.putString(TITLE, note.title)
                    bundle.putString(DESCRIPTION, note.description)
                    Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_addNotesFragment, bundle)
                }
                binding.deleteButton.setOnClickListener {
                    onItemClickListener?.onItemClick(it, note)
                }

            }
        }
    }

    interface OnItemClickListener{

        fun onItemClick(v : View, data : Notes)
    }

    companion object{
        const val TITLE = "title"
        const val DESCRIPTION = "description"
    }


}