package cl.example.bitcoinwallet

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class WalletViewModel: ViewModel() {

    private val repository = Repository()

    fun selected(): LiveData<Wallet> = selected
    private val selected = MutableLiveData<Wallet>()

    fun getWalletDetail(): LiveData<Wallet> = repository.walletDetail

    init {
        viewModelScope.launch {
            repository.getWalletTransaction()
        }
    }
}