package cl.example.bitcoinwallet

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class WalletViewModel: ViewModel() {

    private val repository = Repository()

    fun selected(): LiveData<Wallet> = selected
    private val selected = MutableLiveData<Wallet>()

    fun selectedTransaction(): LiveData<WalletDetail> = selectedTransaction
    private val selectedTransaction = MutableLiveData<WalletDetail>()

    fun getWallet(): LiveData<Wallet> = repository.wallet

    fun getWalletDetail(): LiveData<WalletDetail> = repository.walletDetail

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