package cl.example.bitcoinwallet.viewmodel

import androidx.lifecycle.*
import cl.example.bitcoinwallet.model.Repository
import cl.example.bitcoinwallet.model.pojo.Wallet
import cl.example.bitcoinwallet.model.pojo.WalletDetail
import kotlinx.coroutines.launch

class WalletViewModel: ViewModel() {

    private val repository = Repository()

    fun selected(): LiveData<Wallet> = selected
    private val selected = MutableLiveData<Wallet>()

    fun selectedTransaction(): LiveData<WalletDetail> = selectedTransaction
    private val selectedTransaction = MutableLiveData<WalletDetail>()

    fun getWallet(): LiveData<Wallet> = repository.wallet

    fun getWalletDetail(): MutableLiveData<WalletDetail> = repository.walletDetail

    init {
        viewModelScope.launch {
            repository.getWalletTransaction()
        }
    }

    init {
        viewModelScope.launch {
            repository.getWalletTransactionDetail()
        }
    }
}