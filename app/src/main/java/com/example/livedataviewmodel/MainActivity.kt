package com.example.livedataviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedataviewmodel.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

//https://www.youtube.com/watch?v=-b0VNKw_niY

class MainActivity : AppCompatActivity(), View.OnClickListener {
    // 전역 변수로 바인딩 객체 선언
    private lateinit var binding: ActivityMainBinding
    lateinit var myNumberViewModel: MyNumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myNumberViewModel = ViewModelProvider(this).get(MyNumberViewModel::class.java)

        myNumberViewModel.currentValue.observe(this, Observer {
            Log.d(TAG, "Main")
            binding.numberTextview.text = it.toString()
        })

        btn_plus.setOnClickListener(this)
        btn_minus.setOnClickListener(this)
    }

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onClick(view: View?) {
        var userInput = userinput_edittext.text.toString().toInt()

        when (view) {
            btn_plus ->{
                myNumberViewModel.updateValue(actionType = ActionType.PLUS, userInput)
            }
            btn_minus ->{
                myNumberViewModel.updateValue(actionType = ActionType.MINUS, userInput)
            }
        }
    }
}