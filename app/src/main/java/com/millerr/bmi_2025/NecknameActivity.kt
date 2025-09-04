package com.millerr.bmi_2025

import android.R.attr.text
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import com.millerr.bmi_2025.databinding.ActivityNecknameBinding
import kotlin.jvm.java

class NecknameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNecknameBinding
    val TAG = NecknameActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNecknameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val level = intent.getIntExtra("EXTRA_LEVEL", 0)
        val name = intent.getStringExtra("NAME")
        Log.d(TAG, "onCreate: , $level, $name")

    }

    fun save(view: View){
        val neckname = binding.edNeckname.text.toString()
        getSharedPreferences("guess", MODE_PRIVATE)
            .edit()
            .putString("nickname", neckname)
            .apply()

        Log.d(TAG, "neckNameActivity: $neckname")
        setResult(RESULT_OK, intent.putExtra("NECK", neckname))
        finish()
    }
}