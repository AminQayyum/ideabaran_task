package ir.amin_qayyum.ideabarantask.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.socket.client.IO
import io.socket.client.Socket
import ir.amin_qayyum.ideabarantask.home.TokenViewModel
import ir.amin_qayyum.ideabarantask.repo.Repository
import ir.amin_qayyum.ideabarantask.network.APIService
import ir.amin_qayyum.ideabarantask.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideSocket(): Socket {
        val opts = IO.Options()
        opts.path = "/api/v1/coindata/socket.io"
        opts.secure = true

        return IO.socket("http://193.29.104.132:30300", opts)
    }

    @Singleton
    @Provides
    fun provideApi() =
        Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(APIService::class.java)

    @Singleton
    @Provides
    fun provideRepository(api: APIService) =
        Repository(api)

    @Singleton
    @Provides
    fun provideViewModel(repository: Repository,socket: Socket) =
        TokenViewModel(repository,socket)
}