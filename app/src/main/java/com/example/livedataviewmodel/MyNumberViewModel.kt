package com.example.livedataviewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


enum class ActionType {
    PLUS, MINUS
}

//
class MyNumberViewModel : ViewModel() {

    companion object {
        private const val TAG = "MyNumberViewModel"
    }

    //변경하도록 설정정
    private val _currentValue = MutableLiveData<Int>()

    val currentValue: LiveData<Int>
        get() = _currentValue

    //초기값 설정
    init {
        Log.d(Companion.TAG, "MyNumberViewModel")
        _currentValue.value = 0
    }

    fun updateValue(actionType: ActionType, input: Int) {
        when (actionType) {
            ActionType.PLUS -> {
                _currentValue.value = _currentValue.value?.plus(input)
            }
            ActionType.MINUS -> {
                _currentValue.value = _currentValue.value?.minus(input)
            }
        }
    }
}