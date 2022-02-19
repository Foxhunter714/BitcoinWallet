package cl.example.bitcoinwallet.remote

import cl.example.bitcoinwallet.Wallet
import retrofit2.Response
import retrofit2.http.GET

interface BitcoinAPI {
    @GET("/addrs/1J38WorKngZLJvA7qMin9g5jqUfTQUBZNE;1JP8FqoXtCMrR1sZc2McLWmHxENox1Y1PV;1ENn7XmqXNnReiQEFHhBGzfiv5gAyBj7r1/balance")
    suspend fun getBooks(): Response<List<Wallet>>
}