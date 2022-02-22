package cl.example.bitcoinwallet.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.example.bitcoinwallet.R
import cl.example.bitcoinwallet.WalletViewModel
import cl.example.bitcoinwallet.databinding.FragmentHistorialTransactionBinding
import cl.example.bitcoinwallet.databinding.ItemHistoryTransactionBinding

class HistorialTransactionFragment : Fragment() {
    private lateinit var binding: ItemHistoryTransactionBinding
    private val viewModel: WalletViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ItemHistoryTransactionBinding.inflate(layoutInflater)

        /*viewModel.getWalletDetail().observe(viewLifecycleOwner, {
           binding.tvDate.text = it.confirmed
        })*/

        viewModel.getWallet().observe(viewLifecycleOwner, {
            binding.tvBalance.text = it.balance.toString()
            binding.tvAddressTransaction.text = it.address
            binding.tvFinalBalance.text = it.txrefs[0].ref_balance.toString()
            //binding.tvFinalBalance.text = it.final_balance.toString()
            binding.tvDate.text = it.txrefs[0].confirmed
        })
        return binding.root
    }
}