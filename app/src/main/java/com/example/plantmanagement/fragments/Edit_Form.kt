package com.example.plantmanagement.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.plantmanagement.R
import com.example.plantmanagement.activity.Edit_Form
import com.example.plantmanagement.adapter.Photo_Adapter
import com.example.plantmanagement.database.PlantDatabase
import com.example.plantmanagement.model.Plant
import com.example.plantmanagement.model.Plant_Category
import com.example.plantmanagement.viewmodel.PlantViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class Edit_Form : Fragment()  {
    lateinit var  photoAdapter: Photo_Adapter
    var dataList = mutableListOf<Plant>()

    private var layoutManager: RecyclerView.LayoutManager? = null
    private lateinit var adapter: RecyclerView.Adapter<Photo_Adapter.ViewHolder>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

     override fun onCreateView(inflater: LayoutInflater,
                               container: ViewGroup?, savedInstanceState: Bundle?): View? {

        lateinit var  photoAdapter: Photo_Adapter
        lateinit var plantViewModel: PlantViewModel

        var dataList = mutableListOf<Plant>()
        val view: View = inflater.inflate(R.layout.fragment_edit__form, container, false)
        val fab = view.findViewById(R.id.floatingActionButton) as FloatingActionButton
        val recyclerView = view.findViewById(R.id.recyclerView) as RecyclerView
        var plants = mutableListOf<Plant_Category>()


        //plants.add(Plant_Category(1, "Strawberry","2 times a day","Water more in summer, Can cause irritation to cats"))
        //plants.add(Plant_Category(2, "Aloe","2 times a week","Water more in summer, Is not safe to digest for pets"))
        //plants.add(Plant_Category(3, "Money tree", "1-2 times a week","Needs medium to bright indirect light, Safe for pets"))

        //dataList.add(Plant(1,"Living room Aloe", plants [1],R.drawable.plantlogo))
        //dataList.add(Plant(2,"Balcony Strawberry",plants [0],R.drawable.plantlogo))
        //dataList.add(Plant(3,"Benny",plants[2],R.drawable.plantlogo))



        recyclerView.layoutManager = GridLayoutManager(context, 2)
        photoAdapter = Photo_Adapter(context)
        recyclerView.adapter = photoAdapter



         plantViewModel = ViewModelProvider(this).get(PlantViewModel::class.java)
        plantViewModel.allPlants.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            photoAdapter.setDataList(it)
            photoAdapter.notifyDataSetChanged()

        })

       // photoAdapter.setDataList(dataList)
        //Floating button that opens the Form in order to add plant
        fab?.setOnClickListener {

            val intent = Intent(view.context, Edit_Form::class.java)
           startActivity(intent);
        }

        return view

    }



}