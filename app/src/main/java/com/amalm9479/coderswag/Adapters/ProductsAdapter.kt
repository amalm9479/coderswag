package com.amalm9479.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amalm9479.coderswag.Model.Product
import com.amalm9479.coderswag.R

class ProductsAdapter(val context: Context, val products:List<Product>) : RecyclerView.Adapter<ProductsAdapter.ProductHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_list_item,parent,false)
        return ProductHolder(view)
    }

    override fun onBindViewHolder(Holder: ProductHolder, position: Int) {
        Holder.bindProduct(products[position],context)
    }

    override fun getItemCount(): Int {
    return products.count()
    }
inner class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val productImage = itemView?.findViewById<ImageView>(R.id.productImage)
    val productName = itemView?.findViewById<TextView>(R.id.productName)
    val productPrice = itemView?.findViewById<TextView>(R.id.productPrice)

    fun bindProduct(product: Product,context: Context){
        val resourceId = context.resources.getIdentifier(product.image,"drawable",context.packageName)
        productImage.setImageResource(resourceId)
        productName.text = product.title
        productPrice.text =product.price
    }

}

}