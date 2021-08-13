package com.example.plantmanagement.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.plantmanagement.R
import com.example.plantmanagement.fragments.Edit_Form
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager
                .findFragmentById(R.id.FragmentContainer) as NavHostFragment
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(navView, navController)
        }
    }



