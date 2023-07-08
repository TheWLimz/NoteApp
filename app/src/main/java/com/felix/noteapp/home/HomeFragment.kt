package com.felix.noteapp.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.felix.noteapp.R
import com.felix.noteapp.adapter.NoteAdapter
import com.felix.noteapp.core.domain.data.Notes
import com.felix.noteapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = GridLayoutManager(requireActivity(), 2)
        binding.noteRecyclerView.layoutManager = layoutManager

        homeViewModel.notes.observe(viewLifecycleOwner){
            setNotesList(it)
        }


        binding.fab.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_addNotesFragment)
        }
    }

    private fun setNotesList(notes : List<Notes>){
        val notesList = ArrayList<Notes>()
        notes.map { note ->
            notesList.add(
                Notes(
                    description = note.description,
                    title = note.title
                )
            )
        }

        val adapter = NoteAdapter(notesList)
        binding.noteRecyclerView.adapter = adapter
        adapter.onItemClickListener = object : NoteAdapter.OnItemClickListener{
            override fun onItemClick(v: View, data : Notes) {
                homeViewModel.delete(data)
                showToast("Successfully deleted a note")
            }

        }

    }

    private fun showToast(message : String){
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }




}