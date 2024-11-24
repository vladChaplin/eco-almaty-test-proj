package kz.enactus.ecoalmaty.android.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val _token = MutableStateFlow<String?>(null)
    val token: StateFlow<String?> = _token

    fun saveToken(token: String) {
        viewModelScope.launch {
            _token.emit(token)
        }
    }

    fun getToken(): String? {
        return _token.value
    }
}