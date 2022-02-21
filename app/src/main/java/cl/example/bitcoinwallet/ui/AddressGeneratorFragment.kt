package cl.example.bitcoinwallet.ui

import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import cl.example.bitcoinwallet.databinding.FragmentAddressGeneratorBinding
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter


class AddressGeneratorFragment : Fragment() {
    private lateinit var binding: FragmentAddressGeneratorBinding
    private lateinit var ivQRCode: ImageView
    private lateinit var etData: EditText
    private lateinit var btnGeneratorQRCode: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     binding = FragmentAddressGeneratorBinding.inflate(layoutInflater)

     btnGeneratorQRCode = binding.btnGenerate
        etData = binding.etAddress
        ivQRCode = binding.ivQRCode
     btnGeneratorQRCode.setOnClickListener {
            val data = etData.text.toString().trim()

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