package online.asaphmwangi.garimpya


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.recyclerview.widget.GridLayoutManager

import androidx.recyclerview.widget.RecyclerView
import online.asaphmwangi.garimpya.datamanagement.VehicleAdapter
import online.asaphmwangi.garimpya.datamanagement.VehicleDetails

class SearchActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var vehicleAdapter: VehicleAdapter
    private lateinit var vehicleList: List<VehicleDetails>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Set status bar color
        @Suppress("DEPRECATION")
        window.statusBarColor = ContextCompat.getColor(this, R.color.fifth)

        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = false

        // Request focus to Search Input
        val editText = findViewById<EditText>(R.id.search_input)
        editText.requestFocus()

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
        topPicksList()
    }
    //Search algorithm
    private fun topPicksList()
    {
        recyclerView = findViewById(R.id.search_recycler)
        recyclerView.layoutManager = GridLayoutManager(this, 2)


        vehicleList = listOf(
            VehicleDetails(
                R.drawable.car_blue,
                "Bugatti",
                "$3000",
                "Nairobi",
                "2023",
                "3000km"), VehicleDetails(
                R.drawable.car_black,
                "Lamborghini",
                "$5000",
                "Mombasa",
                "2024",
                "1000km"),
            VehicleDetails(
                R.drawable.car_blue,
                "Bugatti",
                "$3000",
                "Nairobi",
                "2023",
                "3000km"), VehicleDetails(
                R.drawable.car_black,
                "Lamborghini",
                "$5000",
                "Mombasa",
                "2024",
                "1000km")
        )

        vehicleAdapter = VehicleAdapter(vehicleList)
        recyclerView.adapter =vehicleAdapter
    }
    fun openMainActivity(view: View)
    {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}