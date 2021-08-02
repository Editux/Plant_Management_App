package com.example.plantmanagement.fragments

import android.content.Intent
import android.os.Bundle
import android.telecom.Call.Details
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.plantmanagement.R
import com.example.plantmanagement.activity.Edit_Form
import com.google.android.material.floatingactionbutton.FloatingActionButton


class Edit_Form : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_edit__form, container, false)
        val fab = view.findViewById(R.id.floatingActionButton) as FloatingActionButton
        //Floating button that opens the Form in order to add plant
        fab?.setOnClickListener {

            val intent = Intent(view.context, Edit_Form::class.java)
           startActivity(intent);
        }

        return view

    }



}