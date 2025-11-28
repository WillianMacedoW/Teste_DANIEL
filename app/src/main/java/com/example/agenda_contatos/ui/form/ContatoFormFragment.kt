package com.example.agenda_contatos.ui.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.agenda_contatos.databinding.FragmentContatoFormBinding
import com.google.android.material.snackbar.Snackbar

class ContatoFormFragment : Fragment() {

    private var _binding: FragmentContatoFormBinding? = null
    private val binding get() = _binding!!

    private val args: ContatoFormFragmentArgs by navArgs()
    private val viewModel: ContatoFormViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentContatoFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        viewModel.loadContato(args.contatoId)

        binding.actionSalvar.setOnClickListener {
            viewModel.salvarContato()
        }

        viewModel.saved.observe(viewLifecycleOwner) { saved ->
            if (saved) {
                findNavController().navigateUp()
                viewModel.resetarEstadoSalvo()
            }
        }

        viewModel.erro.observe(viewLifecycleOwner) { mensagem ->
            mensagem?.let {
                Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
                viewModel.consumirErro()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
