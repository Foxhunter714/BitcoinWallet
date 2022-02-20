package cl.example.bitcoinwallet

import androidx.room.Entity
import androidx.room.PrimaryKey

class WalletDatabase {
    @Entity(tableName = "wallet")
    data class WalletEntity(@PrimaryKey val id:Int)
}