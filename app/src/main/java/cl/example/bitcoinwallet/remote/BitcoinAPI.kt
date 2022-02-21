package cl.example.bitcoinwallet.remote

import cl.example.bitcoinwallet.Wallet
import retrofit2.Response
import retrofit2.http.GET

interface BitcoinAPI {
    @GET("addrs/tb1qy26cyvmvtx4qlakavj3k68lhd8ny2y89flcrhn")
    suspend fun getWalletTransaction(): Response<Wallet>
}