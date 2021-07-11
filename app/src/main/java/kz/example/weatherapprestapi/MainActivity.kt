package kz.example.weatherapprestapi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kz.example.weatherapprestapi.fragments.weather_result.WeatherFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            val editText = findViewById<EditText>(R.id.editText).text.toString()

            /*val llBottomSheet = findViewById<View>(R.id.bottom_sheet) as LinearLayout

// настройка поведения нижнего экрана

// настройка поведения нижнего экрана
            val bottomSheetBehavior: BottomSheetBehavior<*> =
                BottomSheetBehavior.from(llBottomSheet)

// настройка состояний нижнего экрана

// настройка состояний нижнего экрана
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

// настройка максимальной высоты

// настройка максимальной высоты
            bottomSheetBehavior.peekHeight = 340

// настройка возможности скрыть элемент при свайпе вниз

// настройка возможности скрыть элемент при свайпе вниз
            bottomSheetBehavior.isHideable = false*/

            showFragment(editText)
        }
    }

    private fun showFragment(text:String){
        val fragment = WeatherFragment()
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragmentContainer, fragment, "Fragment")
            .commit()
    }
}