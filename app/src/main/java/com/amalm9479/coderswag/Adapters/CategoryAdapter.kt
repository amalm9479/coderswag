package com.amalm9479.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.amalm9479.coderswag.Model.Category
import com.amalm9479.coderswag.R

class CategoryAdapter(context:Context, categories:List<Category>) : BaseAdapter() {
    val context=context
    val categories=categories

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView:View

        categoryView=LayoutInflater.from(context).inflate(R.layout.category_list_item,null)
        val categoryImage : ImageView=categoryView.findViewById(R.id.categoryImage)
        val categoryName : TextView=categoryView.findViewById(R.id.categoryName)

        val category = categories[position]

        val resourceId = context.resources.getIdentifier(category.image,"drawable",context.packageName)
        categoryImage.setImageResource(resourceId)
        println(resourceId)

        categoryName.text =category.title
        return categoryView
    }

    override fun getCount(): Int {
    return categories.count()
    }

    override fun getItem(position: Int): Any {
    return  categories[position]
     }

    override fun getItemId(position: Int): Long {
    return 0
    }


}