package net.paulbogdan.contactslist.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.input.key.Key.Companion.D
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import net.paulbogdan.contactslist.model.User
import net.paulbogdan.contactslist.network.ApiService
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val apiService: ApiService,
) : BaseViewModel() {

    var userList = mutableStateListOf<User>()

    fun getUsers() {
        notifyIsLoading()
        disposeContainer.add(
            apiService.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    if (response.isSuccessful) {
                        response.body()?.forEach { user ->
                            userList.add(user)
                        }
                    } else {
                        Log.d("GET USERS ERROR", response.toString())
                        this.onError = response.message()
                        this.hasError = true
                    }
                    notifyFinishedLoading()
                }, { err ->
                    this.onError = err.toString()
                    this.hasError = true
                    notifyFinishedLoading()
                    Log.d("GET USERS ERROR", err.toString())
                })
        )
    }
}