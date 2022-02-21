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
            //binding.tvDate.text = wallet.date
            binding.tvBalance.text = wallet.balance.toString()
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
}