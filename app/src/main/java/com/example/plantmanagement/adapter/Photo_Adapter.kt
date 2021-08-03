package com.example.plantmanagement.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.plantmanagement.R
import com.example.plantmanagement.activity.PlantDetails
import com.example.plantmanagement.model.Plant


class Photo_Adapter(var context: Context?) : RecyclerView.Adapter<Photo_Adapter.ViewHolder>() {

        var dataList = emptyList<Plant>()

        internal fun setDataList(dataList: List<Plant>) {
            this.dataList = dataList
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        var data = dataList[position]


        holder.title.text = data.name
        holder.desc.text = data.type.toString()


        holder.image.setImageResource(data.image)
        holder.relativeLayout.setOnClickListener { view -> //Toast.makeText(view.getContext(),"click on item: "+model.getTitle(),Toast.LENGTH_LONG).show();
            val intent = Intent(view.context, PlantDetails::class.java)
            intent.putExtra("plant_name", data.name)
            intent.putExtra("plant_image",data.image)
            intent.putExtra("plant_type", data.type.type)
            intent.putExtra("plant_water", data.type.water_time)
            intent.putExtra("plant_details", data.type.details)
            view.context.startActivity(intent)
    }

}

        // Provide a direct reference to each of the views with data items

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var image: ImageView
            var title: TextView
            var desc: TextView
            var relativeLayout: CardView

            init {
                image = itemView.findViewById(R.id.image)
                title = itemView.findViewById(R.id.title)
                desc = itemView.findViewById(R.id.desc)
                relativeLayout = itemView.findViewById<View>(R.id.relativeLayout) as CardView
            }

        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Photo_Adapter.ViewHolder {

            // Inflate the custom layout
            var view = LayoutInflater.from(parent.context).inflate(R.layout.photo_layout, parent, false)
            return ViewHolder(view)
        }




        //  total count of items in the list
        override fun getItemCount() = dataList.size

}
