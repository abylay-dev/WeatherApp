package kz.example.weatherapprestapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            val editText = findViewById<EditText>(R.id.editText).text.toString()
            showFragment(editText)
        }

    }

    private fun showFragment(text:String){
        val fragment = wFragment(text)
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragmentLayout, fragment, "Fragment")
            .commit()
    }
}