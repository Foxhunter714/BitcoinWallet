package cl.example.bitcoinwallet.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.blockcypher.com/v1/btc/test3"
class RetrofitClient {
    companion object {
        fun retrofitInstance(): BitcoinAPI {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()
            ).build()

            return retrofit.create(BitcoinAPI::class.java)
        }
    }
}