package cl.example.bitcoinwallet.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cl.example.bitcoinwallet.view.TransactionAdapter
import cl.example.bitcoinwallet.viewmodel.WalletViewModel
import cl.example.bitcoinwallet.databinding.FragmentHistorialTransactionBinding

class HistorialTransactionFragment : Fragment() {
    private lateinit var binding: FragmentHistorialTransactionBinding
    private val viewModel: WalletViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistorialTransactionBinding.inflate(layoutInflater)
        binding.rvHistoryTransaction.layoutManager = LinearLayoutManager(context)
        val adapter = TransactionAdapter()
        binding.rvHistoryTransaction.adapter = adapter
        /*viewModel.getWalletDetail().observe(viewLifecycleOwner, {
           binding.tvDate.text = it.confirmed
        })*/

        viewModel.getWallet().observe(viewLifecycleOwner, {
            adapter.update(it)
        //binding.tvBalance.text = it.ref_balance.toString()
            //binding.tvBalance.text = it.balance.toString()
            //binding.tvAddressTransaction.text = it.address
            //binding.tvFinalBalance.text = it.txrefs[0].ref_balance.toString()
            //binding.tvFinalBalance.text = it.final_balance.toString()
            //binding.tvDate.text = it.txrefs[0].confirmed
            //binding.tvDate.text = it.confirmed
        })
        return binding.root
    }
}