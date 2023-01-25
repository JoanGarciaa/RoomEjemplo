package com.example.roomexemple.init

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.roomexemple.R
import com.example.roomexemple.databinding.FragmentInitBinding
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomexemple.listAdapter.ClientRVAdapter
import com.example.roomexemple.listAdapter.RecyclerClickListener
import com.example.roomexemple.viewmodel.UsuariViewModel
import kotlinx.coroutines.launch


class InitFragment : Fragment() {
    private lateinit var adapter: ClientRVAdapter
    lateinit var binding: FragmentInitBinding
    lateinit var usuariViewModel: UsuariViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding =  DataBindingUtil.inflate<FragmentInitBinding>(inflater, R.layout.fragment_init,container,false);
        usuariViewModel = ViewModelProvider(this).get(UsuariViewModel::class.java)
        setRecyclerView()
        observeClient()
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun setRecyclerView() {

        val clientRecyclerview = binding.recyclerView
        clientRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        clientRecyclerview.setHasFixedSize(true)
        adapter = ClientRVAdapter()
        adapter.setItemListener(object : RecyclerClickListener {

            override fun onItemClick(position: Int) {
                val clientList = adapter.currentList.toMutableList()
                Toast.makeText(requireContext(),"${clientList[position].nombre} , ${clientList[position].edad}, ${clientList[position].password}, ${clientList[position].profession} " , Toast.LENGTH_SHORT).show()
            }
        })
        clientRecyclerview.adapter = adapter
    }

    private fun observeClient() {
            usuariViewModel.obtenirClients(requireContext())!!.observe(viewLifecycleOwner, Observer { llistaClient ->
                adapter.submitList(llistaClient)
            })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}