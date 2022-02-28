package cl.example.bitcoinwallet.model.remote

import cl.example.bitcoinwallet.model.pojo.Wallet
import cl.example.bitcoinwallet.model.pojo.WalletDetail
import retrofit2.Response
import retrofit2.http.GET

interface BitcoinAPI {
    @GET("addrs/tb1qy26cyvmvtx4qlakavj3k68lhd8ny2y89flcrhn")
    suspend fun getWalletTransaction(): Response<Wallet>

    @GET("addrs/tb1qy26cyvmvtx4qlakavj3k68lhd8ny2y89flcrhn")
    suspend fun getWalletTransactionDetail(): Response<WalletDetail>
}