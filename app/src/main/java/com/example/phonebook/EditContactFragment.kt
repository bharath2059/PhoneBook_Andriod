package com.example.phonebook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.phonebook.databinding.FragmentEditContactBinding

class EditContactFragment : Fragment() {

    private var _binding: FragmentEditContactBinding? =null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditContactBinding.inflate(inflater, container, false);
        val view = binding.root;
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}