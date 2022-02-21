package cl.example.bitcoinwallet

import androidx.lifecycle.MutableLiveData
import cl.example.bitcoinwallet.remote.RetrofitClient
import timber.log.Timber

class Repository {

    private val walletDatabase = WalletApplication.walletDatabase!!

    val wallets = walletDatabase.walletDao().getWallet()

    val walletDetail: MutableLiveData<Wallet> = MutableLiveData()

    suspend fun getWalletTransaction(){
        Timber.d("getWalletTransaction")
        val response = RetrofitClient.retrofitInstance().getWalletTransaction()

        when(response.isSuccessful){
            true-> response.body()?.let{
                walletDetail.value = it }
            false-> Timber.d("${response.body()}")
            }
        }
    }
