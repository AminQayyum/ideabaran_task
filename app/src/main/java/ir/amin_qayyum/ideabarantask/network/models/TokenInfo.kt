package ir.amin_qayyum.ideabarantask.network.models


import com.google.gson.annotations.SerializedName

data class TokenInfo(
    val buyPrice: Double,
    val change: Double,
    val coin: String,
    val enName: String,
    val faName: String,
    val icon: String,
    val market: String,
    val minimumWithdraw: Double,
    val quoteIncrement: Double,
    val quoteMinSize: Double,
    val sellPrice: Double,
    val symbol: String,
    @SerializedName("USDPrice")
    val uSDPrice: Double,
    val withdrawFee: Double
)