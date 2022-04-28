package com.example.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.mvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenterImp: MainPresenterImp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenterImp = MainPresenterImp(this)
        binding.btnSubmit.setOnClickListener {
            presenterImp.addJumlah(
                binding.etNumber1.text.toString(),
                binding.etNumber2.text.toString()
            )
        }
        binding.btnRiwayat.setOnClickListener{
            presenterImp.loadData()
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showData(data: String) {
        AlertDialog
            .Builder(this)
            .setTitle("History")
            .setNegativeButton("close"){dialog,_->
                dialog.dismiss()

            }
            .setMessage(data)
            .create()
            .show()

    }

    override fun clearField() {
        binding.etNumber1.text?.clear()
        binding.etNumber2.text?.clear()
    }
}