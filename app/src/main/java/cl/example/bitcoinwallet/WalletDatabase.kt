package cl.example.bitcoinwallet

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*
import timber.log.Timber

    //Pojos (entities)
    @Entity(tableName = "wallet")
    data class WalletEntity(@PrimaryKey val address: String, val balance: Int, val final_balance: Int)

    //Operation Interfaces
    @Dao
    interface WalletDao{
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insert(wallet: List<WalletEntity>)

        @Query("SELECT * FROM wallet")
        fun getWallet(): LiveData<List<WalletEntity>>
    }

    //DDBB Wallet
    @Database(entities = [WalletEntity::class], version = 1)
    abstract class WalletDatabase: RoomDatabase(){
        abstract fun walletDao(): WalletDao
    }

    //DDBB Initialization
    class WalletApplication: Application(){
        companion object{
            var walletDatabase : WalletDatabase? = null
        }

        override fun onCreate() {
            super.onCreate()
            Timber.d("onCreate Application")
            walletDatabase = Room.databaseBuilder(this, WalletDatabase::class.java, "wallet_database").build()
        }
    }
