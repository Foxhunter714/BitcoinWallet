data class WalletJSon(
    val address: String,
    val balance: Int,
    val final_balance: Int,
    val final_n_tx: Int,
    val n_tx: Int,
    val total_received: Int,
    val total_sent: Int,
    val tx_url: String,
    val txrefs: List<Txref>,
    val unconfirmed_balance: Int,
    val unconfirmed_n_tx: Int
)