package cl.example.bitcoinwallet.ui

import android.graphics.Bitmap
import android.graphics.Color
import android.icu.text.CaseMap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import cl.example.bitcoinwallet.databinding.FragmentAddressGeneratorBinding
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter
import java.util.*
import kotlin.random.Random


class AddressGeneratorFragment : Fragment() {
    private lateinit var binding: FragmentAddressGeneratorBinding
    private lateinit var ivQRCode: ImageView
    private lateinit var btnGeneratorQRCode: Button
    private lateinit var btnGeneratorAddress: Button
    private lateinit var btnSaveAddress: Button
    private lateinit var tvTitle: TextView
    private lateinit var tvAddress: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     binding = FragmentAddressGeneratorBinding.inflate(layoutInflater)

        tvTitle = binding.tvTitle
        btnGeneratorQRCode = binding.btnGenerate
        btnGeneratorAddress = binding.btnGenerateAddress
        btnSaveAddress = binding.btnSaveAddress
        tvAddress = binding.tvAddress
        ivQRCode = binding.ivQRCode


        btnGeneratorAddress.setOnClickListener {
            val myRandomAddress = mutableListOf("tb1qp824t5qzmrq5tp9lzr87pk580apqdk6lvat333",
                "miBoHmZJYrDsZohsd5Kp2bjh68TParsyME", "2N3gQFsqqsJscuB1C7XTq6puJ1rU5QEakfP","mneiR8AnWiYjHSNiB1f91JojwryhwEq1oT",
                "n4MtG4d8JVV5SyQvbnkf8YjeLK4L4A9HWY", "tb1qxl6vckqsjzzx89p7nm73ya8dt588g4uma0ycrl")
            tvAddress.text = myRandomAddress.random().toString()
        }
     btnGeneratorQRCode.setOnClickListener {
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
        }
        return binding.root
    }
}