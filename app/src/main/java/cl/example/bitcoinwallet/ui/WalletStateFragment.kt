package cl.example.bitcoinwallet.ui

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResult
import cl.example.bitcoinwallet.WalletViewModel
import cl.example.bitcoinwallet.databinding.FragmentWalletStateBinding
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter

class WalletStateFragment : Fragment() {
    private lateinit var binding: FragmentWalletStateBinding
    private lateinit var ivQRCode: ImageView
    private lateinit var tvWalletBit: TextView
    private lateinit var tvTitle: TextView
    private lateinit var tvAddress: TextView
    private val viewModel: WalletViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = FragmentWalletStateBinding.inflate(layoutInflater)

        ivQRCode = binding.ivQRCode
        tvWalletBit = binding.tvWalletBit
        tvTitle = binding.tvTitle
        tvAddress = binding.tvAddress

        val myRandomAddress = mutableListOf("tb1qp824t5qzmrq5tp9lzr87pk580apqdk6lvat333",
            "miBoHmZJYrDsZohsd5Kp2bjh68TParsyME", "2N3gQFsqqsJscuB1C7XTq6puJ1rU5QEakfP","mneiR8AnWiYjHSNiB1f91JojwryhwEq1oT",
            "n4MtG4d8JVV5SyQvbnkf8YjeLK4L4A9HWY", "tb1qxl6vckqsjzzx89p7nm73ya8dt588g4uma0ycrl")
        val str: String = myRandomAddress.random().toString()
        val args = this.arguments
        val inputData = args?.get("data")
        //tvAddress.text = inputData.toString()
        tvAddress.text = str

        val data = tvAddress.text.toString().trim()
        if (data.isEmpty()){
            Toast.makeText(this.requireActivity(),"", Toast.LENGTH_SHORT).show()
        } else {
            val writer = QRCodeWriter()
            try {
                val bitMatrix = writer.encode(data, BarcodeFormat.QR_CODE, 512, 512)
                val width = bitMatrix.width
                val height = bitMatrix.height
                val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
                for(x in 0 until width){
                    for (y in 0 until height){
                        bmp.setPixel(x, y, if(bitMatrix[x, y]) Color.BLACK else Color.WHITE)
                    }
                }
                ivQRCode.setImageBitmap(bmp)
            } catch (e: WriterException){
                e.printStackTrace()
            }
        }

        viewModel.getWallet().observe(viewLifecycleOwner, {
            binding.tvWalletBit.text = it.balance.toString()
            binding.tvWalletBitBalance.text = it.final_balance.toString()
            binding.tvWalletBitUnconfirmed.text = it.unconfirmed_balance.toString()
        })

        return binding.root
    }
}