package ir.amin_qayyum.ideabarantask.home

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import io.socket.client.Socket
import ir.amin_qayyum.ideabarantask.network.models.TokenInfo
import ir.amin_qayyum.ideabarantask.repo.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.*
import javax.inject.Inject

@HiltViewModel
class TokenViewModel @Inject constructor(
    private val repository: Repository,
    private val socket: Socket
) : ViewModel() {

    init {
        getTokenList()
    }

    private var _tokenInfoList  = MutableStateFlow<List<TokenInfo>>(listOf())
    var stateOfTokenInfoList = _tokenInfoList.asStateFlow()

    private fun getTokenList() {
        socket.connect()
        socket.on("COIN_DATA_SET") { arg ->
            _tokenInfoList.value =
                 Gson().fromJson(arg[0].toString(), Array<TokenInfo>::class.java)
                     .toList()
        }
    }

    override fun onCleared() {
        super.onCleared()
        socket.disconnect()
        socket.close()
    }

}