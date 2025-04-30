package online.asaphmwangi.garimpya

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.firebase.auth.FirebaseAuth
import online.asaphmwangi.garimpya.authentication.FirebaseAuthentication
import online.asaphmwangi.garimpya.authentication.LoginActivity
import online.asaphmwangi.garimpya.bottom_menu.SettingsActivity

class MainActivity : AppCompatActivity() {

    val authManager = FirebaseAuthentication()
    private lateinit var bottom_nav: BottomNavigationView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        @Suppress("DEPRECATION")
        window.statusBarColor = ContextCompat.getColor(this, R.color.fifth)
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = false


        checkLoginStatus()
        setBadge(5)
    }


    //Wishlist badge
    fun setBadge(number_of_vehicles: Int)
    {
        bottom_nav = findViewById(R.id.bottomNavigationView)
        val badge = bottom_nav.getOrCreateBadge(R.id.wishlist)

        // Customize badge
        badge.isVisible = true
        badge.number = number_of_vehicles // Show number, e.g. 5 new notifications
        badge.backgroundColor = ContextCompat.getColor(this, R.color.red)
        badge.badgeTextColor = ContextCompat.getColor(this, R.color.ic_launcher_background)
        badge.horizontalOffset = -0
        badge.verticalOffset = 0

    }




    //Check Login Status
    private fun checkLoginStatus()
    {
        if (!authManager.isLoggedIn()) {

        }


    }

    //Animation when opening the search activity
    fun openSearch(view: View)
    {
        val intent = Intent(this,SearchActivity::class.java)
        startActivity(intent)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            // API 34 and above
            overrideActivityTransition(
                Activity.OVERRIDE_TRANSITION_OPEN,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            )
        } else {
            // Below API 34
            @Suppress("DEPRECATION")
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }



    //Open settings
    fun openSettings(item: MenuItem) {
        val intent = Intent(this,SettingsActivity::class.java)
        startActivity(intent)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            // API 34 and above
            overrideActivityTransition(
                Activity.OVERRIDE_TRANSITION_OPEN,
                R.anim.slide_in_right,
                R.anim.slide_out_left
            )
        } else {
            // Below API 34
            @Suppress("DEPRECATION")
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }


    //State management
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //outState.putString("user_input", editText.text.toString())
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val savedText = savedInstanceState.getString("user_input")
       // editText.setText(savedText)
    }


}
