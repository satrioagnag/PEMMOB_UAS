package com.example.projectuas

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SnackAdapter(private val drinkList: List<Snack>, private val context: Context) : RecyclerView.Adapter<SnackAdapter.DrinkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_snack, parent, false)
        return DrinkViewHolder(view)
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        val drink = drinkList[position]
        holder.snackImage.setImageResource(drink.imageResource)


        holder.itemView.setOnClickListener {
            val intent = Intent(context, SnackDetailActivity::class.java).apply {
                putExtra("drink_name", drink.name)
                putExtra("drink_image", drink.imageResource)
                putExtra("drink_price", drink.price)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return drinkList.size
    }

    class DrinkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val snackImage: ImageView = itemView.findViewById(R.id.snack_image)

    }
}

