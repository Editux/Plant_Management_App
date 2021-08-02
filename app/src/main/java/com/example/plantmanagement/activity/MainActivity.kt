package com.example.plantmanagement.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.plantmanagement.R
import com.example.plantmanagement.fragments.Edit_Form
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        navView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "This is home", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_garden -> {
                    val fragment = Edit_Form()
                    supportFragmentManager.beginTransaction().replace(R.id.FragmentContainer, fragment, fragment.javaClass.getSimpleName())
                            .commit()
                    Toast.makeText(this, "This is garden", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_settings -> {
                    Toast.makeText(this, "This is settings", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }



}