package cl.example.bitcoinwallet.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.example.bitcoinwallet.databinding.ItemHistoryTransactionBinding
import cl.example.bitcoinwallet.model.pojo.Wallet
import java.text.SimpleDateFormat

class TransactionAdapter: RecyclerView.Adapter<TransactionAdapter.TransactionVH>() {
    private var transactionList = listOf<Wallet>()
    private val selectedItem = MutableLiveData<Wallet>()
    fun selectedItem(): LiveData<Wallet> = selectedItem

    val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    val formateStyle8 = "dd-MMM-yyyyThh:mm:ss"
    val formatter = SimpleDateFormat("dd.MMM.yyyy")
    var output = formatter.format(parser.parse("2019-06-24T11:12:3"))

    inner class TransactionVH (val binding: ItemHistoryTransactionBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(wallet: Wallet){
            for (i in 0 until transactionList.size) {
                binding.tvBalance.text = wallet.txrefs[i].ref_balance.toString()
                binding.tvAddress.text = wallet.address
                //binding.tvFinalBalance.text = wallet.txrefs[transactionList.size].ref_balance.toString()
                //binding.tvAddressTransaction.text = wallet.address
                binding.tvDate.text = formatter.format(parser.parse(wallet.txrefs[i].confirmed))
            }
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

    fun update(pTransactionList: Wallet){
        transactionList = listOf(pTransactionList)
        notifyDataSetChanged()
    }

    fun count(){
        var counter = 0
        while (counter < transactionList.size){
            counter++
        }
    }
}