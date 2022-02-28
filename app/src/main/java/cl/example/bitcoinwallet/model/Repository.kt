package cl.example.bitcoinwallet.model

import androidx.lifecycle.MutableLiveData
import cl.example.bitcoinwallet.WalletApplication
import cl.example.bitcoinwallet.model.pojo.Wallet
import cl.example.bitcoinwallet.model.pojo.WalletDetail
import cl.example.bitcoinwallet.model.remote.RetrofitClient
import timber.log.Timber

class Repository {

    private val walletDatabase = WalletApplication.walletDatabase!!

    val wallets = walletDatabase.walletDao().getWallet()
    val wallet: MutableLiveData<Wallet> = MutableLiveData()




    suspend fun getWalletTransaction(){
        Timber.d("getWalletTransaction")
        val response = RetrofitClient.retrofitInstance().getWalletTransaction()

        when(response.isSuccessful){
            true-> response.body()?.let{
                wallet.value = it }
            false-> Timber.d("${response.body()}")
            }
        }

    val walletsDetail = walletDatabase.walletDao().getWalletDetail()
    val walletDetail: MutableLiveData<WalletDetail> = MutableLiveData()

    suspend fun getWalletTransactionDetail(){
        Timber.d("getWalletDetailTransaction")
        val response = RetrofitClient.retrofitInstance().getWalletTransactionDetail()

        when(response.isSuccessful){
            true-> response.body()?.let {
               walletDetail.value = it
            } false -> Timber.d("${response.body()}")
        }
    }
    }
