package cl.example.bitcoinwallet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.example.bitcoinwallet.databinding.ItemHistoryTransactionBinding

class TransactionAdapter: RecyclerView.Adapter<TransactionAdapter.TransactionVH>() {
    private var transactionList = listOf<Wallet>()
    private val selectedItem = MutableLiveData<Wallet>()
    fun selectedItem(): LiveData<Wallet> = selectedItem

    inner class TransactionVH (val binding: ItemHistoryTransactionBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(wallet: Wallet){
            binding.tvBalance.text = wallet.balance.toString()
            //binding.tvFinalBalance.text = wallet.final_balance.toString()
            binding.tvFinalBalance.text = wallet.txrefs[transactionList.size].ref_balance.toString()
            binding.tvAddressTransaction.text = wallet.address
            binding.tvDate.text = wallet.txrefs[transactionList.size].confirmed
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionVH {
        val binding = ItemHistoryTransactionBinding.inflate(LayoutInflater.from(parent.context))
        return TransactionVH(binding)
    }

    override fun onBindViewHolder(holder: TransactionVH, position: Int) {
    val transaction = transactionList[position]
        holder.bind(transaction)
        holder.itemView.setOnClickListener{
            selectedItem.value = transaction
        }
    }

    override fun getItemCount(): Int {
    return transactionList.size
    }

    fun update(pTransactionList: List<Wallet>){
        transactionList = pTransactionList
        notifyDataSetChanged()
    }

    fun count(){
        var counter = 0
        while (counter < transactionList.size){
            counter++
        }
    }
}