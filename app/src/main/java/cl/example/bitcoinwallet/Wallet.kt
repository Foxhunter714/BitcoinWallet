package cl.example.bitcoinwallet

data class Wallet (val address: String, val total_received: Int, val total_sent: Int, val balance: Int, val unconfirmed_balance: Int,
val final_balance: Int, val n_tx:Int, val unconfirmed_n_tx: Int, val final_n_tx: Int)