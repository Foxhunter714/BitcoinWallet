package cl.example.bitcoinwallet.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import cl.example.bitcoinwallet.R
import cl.example.bitcoinwallet.databinding.FragmentMenuBinding
import cl.example.bitcoinwallet.view.ui.AddressGeneratorFragment
import cl.example.bitcoinwallet.view.ui.HistorialTransactionFragment
import cl.example.bitcoinwallet.view.ui.WalletStateFragment

class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    private lateinit var llHistorialIcon: LinearLayout
    private lateinit var llMenu: LinearLayout
    private lateinit var llAddressIcon: LinearLayout
    private lateinit var llWalletIcon: LinearLayout
    private lateinit var llBothIcon: LinearLayout
    private lateinit var llWallet: LinearLayout
    private lateinit var llAddress: LinearLayout
    private lateinit var llHistorial: LinearLayout
    private lateinit var cvWallet: CardView
    private lateinit var cvAddress: CardView
    private lateinit var cvHistorial: CardView
    private lateinit var ivWallet: ImageView
    private lateinit var ivAddress: ImageView
    private lateinit var ivHistorial: ImageView
    private lateinit var tvWallet: TextView
    private lateinit var tvHistorial:TextView
    private lateinit var tvAddress: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(layoutInflater)

        llHistorialIcon = binding.llHistorialIcon
        llAddressIcon = binding.llAddressIcon
        llWalletIcon = binding.llWalletIcon
        llBothIcon = binding.llBothIcon
        llWallet = binding.llWallet
        llAddress = binding.llAddress
        llHistorial = binding.llHistorial
        cvWallet = binding.cvWallet
        cvAddress = binding.cvAddress
        cvHistorial = binding.cvHistorial
        ivHistorial = binding.ivHistorial
        ivWallet = binding.ivWallet
        ivAddress = binding.ivAddress
        tvWallet = binding.tvWallet
        tvHistorial = binding.tvHistorial
        tvAddress = binding.tvAddress

        llAddress.setOnClickListener {
          activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_container, AddressGeneratorFragment())?.addToBackStack("fragmentMenu")?.commit()
        }

        llWallet.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_container, WalletStateFragment())?.addToBackStack("fragmentMenu")?.commit()
        }

        llHistorial.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_container, HistorialTransactionFragment())?.addToBackStack("fragmentMenu")?.commit()
        }
        return binding.root
    }
}