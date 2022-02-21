package cl.example.bitcoinwallet.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.example.bitcoinwallet.R
import cl.example.bitcoinwallet.databinding.FragmentHistorialTransactionBinding

class HistorialTransactionFragment : Fragment() {
    private lateinit var binding: FragmentHistorialTransactionBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistorialTransactionBinding.inflate(layoutInflater)
        return binding.root
    }
}