package com.example.agenda_contatos.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.agenda_contatos.R
import com.example.agenda_contatos.data.Contato
import com.example.agenda_contatos.databinding.FragmentContatoListBinding
import com.example.agenda_contatos.ui.adapter.ContatoAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ContatoListFragment : Fragment() {

    private var _binding: FragmentContatoListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ContatoListViewModel by viewModels()

    private val adapter by lazy {
        ContatoAdapter(
            onView = ::openDetails,
            onLongClick = ::confirmDeletion,
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentContatoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycler.adapter = adapter

        binding.fabAdd.setOnClickListener {
            val action = ContatoListFragmentDirections
                .actionContatoListFragmentToContatoFormFragment()
            findNavController().navigate(action)
        }

        viewModel.contatos.observe(viewLifecycleOwner) { contatos ->
            adapter.submitList(contatos)
            binding.emptyState.visibility = if (contatos.isEmpty()) View.VISIBLE else View.GONE
        }
    }

    private fun openDetails(contato: Contato) {
        val action = ContatoListFragmentDirections
            .actionContatoListFragmentToContatoDetailFragment(contato.id)
        findNavController().navigate(action)
    }

    private fun confirmDeletion(contato: Contato) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(R.string.delete_contato_title)
            .setMessage(getString(R.string.delete_contato_message, contato.nome))
            .setPositiveButton(R.string.action_delete) { _, _ -> viewModel.delete(contato) }
            .setNegativeButton(android.R.string.cancel, null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
