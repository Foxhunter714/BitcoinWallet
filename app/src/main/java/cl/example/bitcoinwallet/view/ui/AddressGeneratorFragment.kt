package cl.example.bitcoinwallet.view.ui

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import cl.example.bitcoinwallet.R
import cl.example.bitcoinwallet.databinding.FragmentAddressGeneratorBinding
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter

open class AddressGeneratorFragment : Fragment() {
    private lateinit var binding: FragmentAddressGeneratorBinding
    private lateinit var ivQRCode: ImageView
    private lateinit var btnGeneratorAddress: Button
    private lateinit var btnSaveAddress: Button
    private lateinit var tvTitle: TextView
    private lateinit var tvAddress: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var txtView: TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     binding = FragmentAddressGeneratorBinding.inflate(layoutInflater)

        tvTitle = binding.tvTitle
        btnGeneratorAddress = binding.btnGenerateAddress
        btnSaveAddress = binding.btnSaveAddress
        tvAddress = binding.tvAddress
        ivQRCode = binding.ivQRCode
        txtView = binding.textView
        progressBar = binding.progressBar

        btnSaveAddress.setOnClickListener {
        val builder = AlertDialog.Builder(this.requireActivity())
            builder.setTitle("Hi there!")
            builder.setMessage(R.string.title_message)
                .setPositiveButton(R.string.dialog_message,
                    DialogInterface.OnClickListener { dialog, id ->
                        activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_container, WalletStateFragment())?.addToBackStack("fragmentAddressGenerator")?.commit()
                    })
                .setNegativeButton(R.string.dialog_message_no,
                    DialogInterface.OnClickListener { dialog, id ->

                    })
            builder.show()
        }

        btnGeneratorAddress.setOnClickListener {
            val visibility = if (progressBar.visibility == View.VISIBLE) View.VISIBLE else View.GONE

            val myRandomAddress = mutableListOf("tb1qp824t5qzmrq5tp9lzr87pk580apqdk6lvat333",
                "miBoHmZJYrDsZohsd5Kp2bjh68TParsyME", "2N3gQFsqqsJscuB1C7XTq6puJ1rU5QEakfP","mneiR8AnWiYjHSNiB1f91JojwryhwEq1oT",
                "n4MtG4d8JVV5SyQvbnkf8YjeLK4L4A9HWY", "tb1qxl6vckqsjzzx89p7nm73ya8dt588g4uma0ycrl")
            val str: String = myRandomAddress.random().toString()
            tvAddress.text = str

            val bundle = Bundle()
            bundle.putString("dataWallet", str)

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
                } catch (e:WriterException){
                    e.printStackTrace()
                }
            }
            progressBar.visibility = visibility


            val walletStateFragment = WalletStateFragment()
            walletStateFragment.arguments = bundle

        }
        return binding.root
  }
}
