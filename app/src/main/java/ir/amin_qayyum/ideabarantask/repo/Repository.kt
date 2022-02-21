package ir.amin_qayyum.ideabarantask.repo

import io.socket.client.Socket
import ir.amin_qayyum.ideabarantask.network.APIService
import ir.amin_qayyum.ideabarantask.network.models.TokenInfo
import javax.inject.Inject

class Repository @Inject constructor(
    val api: APIService
) {

}