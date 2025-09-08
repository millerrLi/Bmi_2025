package com.millerr.bmi_2025

import android.R.id.message
import android.app.ComponentCaller
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.AlertDialogDefaults
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.millerr.bmi_2025.database.GameDatabase
import com.millerr.bmi_2025.database.Record
import com.millerr.bmi_2025.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private val NECKNAME_REQ: Int = 11
    private lateinit var viewModel: GuessViewModel
    private lateinit var binding: ActivityMainBinding
    val TAG = MainActivity2::class.java.simpleName
    val game = GuessGame()
    val requestNickname = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){result ->
        val nickname = getSharedPreferences("guess", MODE_PRIVATE)
            .getString("nickname", null)
        Log.d(TAG, "Data: $nickname")
        if (result.resultCode == RESULT_OK){
            val nickname = result.data?.getStringExtra("NICK")
            Log.d(TAG, "Result: $nickname")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: ")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(GuessViewModel::class.java)
        viewModel.counter.observe(this) { counter ->
            binding.counter.text = counter.toString()
        }
        viewModel.secretData.observe(this){ secret ->
            Toast.makeText(this, "secret: $secret", Toast.LENGTH_LONG).show()
        }

        viewModel.status.observe(this) { status ->
            val message = when(status){
                GameStatus.BIGGER -> getString(R.string.bigger)
                GameStatus.SMALLER -> getString(R.string.smaller)
                GameStatus.INIT -> ""
                else -> getString(R.string.bingo)
            }
            if(status != GameStatus.INIT){
                AlertDialog.Builder(this).setTitle(getString(R.string.info))
                    .setMessage(message)
                    .setPositiveButton(getString(R.string.OK), null)
                    .setNegativeButton("Replay", { dialog, which ->
                        viewModel.reset()
                    })
                    .show()
            }
        }
        //Room test
        val database = Room.databaseBuilder(this,
            GameDatabase::class.java ,
            "game.db")
            .build()
        val record = Record("millerr", 6)
        Thread(){
//            database.recordDao().insert(record)
            val list = database.recordDao().getAll()
            for (r in list){
                Log.d(TAG, "onCreate: ${r.nickname}")
            }
        }.start()

    }

    fun guess(view: View) {
        viewModel.guess(binding.number.text.toString().toInt())
        /*
        if (!binding.number.text.toString().equals("")) {
            var num = binding.number.text.toString().toInt()
            Log.d("MainActivity2", num.toString())
            var message = when(game.guess(num)){
                GuessGame.Status.SMALLER -> getString(R.string.smaller)
                GuessGame.Status.BIGGER -> getString(R.string.bigger)
                else -> getString(R.string.bingo)
            }
            binding.counter.text = game.counter.toString()
            val okListener = object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    TODO("Not yet implemented")
                }

            }
            AlertDialog.Builder(this).setTitle(getString(R.string.info))
                .setMessage(message)
                .setPositiveButton(getString(R.string.OK), null)
                .setNegativeButton("Replay", {dialog, which ->
                    game.reset()
                    binding.counter.text = game.counter.toString()
                })
                .show()
        }else{
            Toast.makeText(this, getString(R.string.please_enter_number_1_10), Toast.LENGTH_LONG).show()
        }
         */
    }

    fun setNickname(view: View){
        val intent = Intent(this, NecknameActivity::class.java)
        intent.putExtra("EXTRA_LEVEL", 3)
        intent.putExtra("NAME", "millerr")
//        startActivity(intent)
//        startActivityForResult(intent, NECKNAME_REQ)
        requestNickname.launch(intent)

        //scope function Kotlin特有的
        Intent(this, NecknameActivity::class.java).apply {
            putExtra("A", "ABC")
            putExtra("B", "Testing")
        }.also { 
            requestNickname.launch(it)
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?,
        caller: ComponentCaller
    ) {
        super.onActivityResult(requestCode, resultCode, data, caller)
        if (requestCode == NECKNAME_REQ){
            Log.d(TAG, "onActivityResult: $requestCode")
            val neckname = data?.getStringExtra("NECK")
            AlertDialog.Builder(this).setTitle("回報")
                .setMessage(neckname)
                .setPositiveButton("ok", null)
                .show()
            Log.d(TAG, "onActivityResult: $neckname")
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }
}