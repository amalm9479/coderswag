package com.amalm9479.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amalm9479.coderswag.Model.Category
import com.amalm9479.coderswag.R
import kotlinx.android.synthetic.main.category_list_item.view.*

class CategoryRecycleAdapter(val context : Context, val categories:List<Category>, val itemClick: (Category)-> Unit) : RecyclerView.Adapter<CategoryRecycleAdapter.Holder>() {

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bindCategory(categories[position], context)
    }
    override fun getItemCount(): Int {
        return categories.count()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.category_list_item,parent,false)
        return Holder(view,itemClick)
    }

    inner class Holder(itemView: View, val itemClick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val categoryImage = itemView.categoryImage
        val categoryName = itemView.categoryName

        fun bindCategory(category:Category,context: Context){
            val resourceId = context.resources.getIdentifier(category.image,
            "drawable", context.packageName)
            categoryImage.setImageResource(resourceId)
            categoryName.text = category.title
            itemView.setOnClickListener { itemClick(category) }
        }
    }

}