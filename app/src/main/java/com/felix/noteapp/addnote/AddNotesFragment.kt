package com.felix.noteapp.addnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.felix.noteapp.R
import com.felix.noteapp.adapter.NoteAdapter
import com.felix.noteapp.core.domain.data.Notes
import com.felix.noteapp.databinding.FragmentAddNotesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNotesFragment : Fragment() {
    
    private lateinit var binding : FragmentAddNotesBinding
    private var note : Notes? = null
    private var isEdit : Boolean = false

    private val addNotesViewModel by viewModels<AddNotesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddNotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = arguments?.getString(NoteAdapter.TITLE)
        val description = arguments?.getString(NoteAdapter.DESCRIPTION)

        if(title != null && description != null){
            isEdit = true
        }

        if(isEdit){
            if(title != null && description != null){
                note = Notes(
                    title = title,
                    description = description
                )

            }
        }



        binding.addButton.setOnClickListener{

            val title = binding.addTitleTextField.text.toString().trim()
            val description = binding.addDescriptionTextField.text.toString().trim()

            note = Notes(
                title = title,
                description = description
            )

            if(isEdit){
                addNotesViewModel.update(note as Notes)
                showToast("Successfully Updated a Note")
            } else{
                addNotesViewModel.insert(note as Notes)
                showToast("Successfully Added a Note")
            }

            Navigation.findNavController(it).navigate(R.id.action_addNotesFragment_to_homeFragment)

        }

        binding.toolbar.setNavigationOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_addNotesFragment_to_homeFragment)
        }

    }

    private fun showToast(message : String){
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }


}