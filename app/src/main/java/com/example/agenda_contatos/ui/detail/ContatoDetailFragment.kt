package com.example.agenda_contatos.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.agenda_contatos.R
import com.example.agenda_contatos.databinding.FragmentContatoDetailBinding

class ContatoDetailFragment : Fragment() {

    private var _binding: FragmentContatoDetailBinding? = null
    private val binding get() = _binding!!

    private val args: ContatoDetailFragmentArgs by navArgs()
    private val viewModel: ContatoDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentContatoDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.actionEdit.setOnClickListener {
            val action = ContatoDetailFragmentDirections
                .actionContatoDetailFragmentToContatoFormFragment(args.contatoId)
            findNavController().navigate(action)
        }

        viewModel.getContato(args.contatoId).observe(viewLifecycleOwner) { contato ->
            if (contato == null) {
                binding.contatoNome.text = getString(R.string.contact_not_found)
                return@observe
            }

            binding.contatoId.text = getString(R.string.contato_id_format, contato.id)
            binding.contatoNome.text = contato.nome
            binding.contatoTelefone.text = getString(R.string.contato_phone, contato.telefone)
            binding.contatoEmail.text = getString(R.string.contato_email, contato.email)
            binding.contatoObservacao.text = getString(R.string.contato_observacao, contato.observacao)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
