package com.amalm9479.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.amalm9479.coderswag.Adapters.CategoryAdapter
import com.amalm9479.coderswag.Model.Category
import com.amalm9479.coderswag.R
import com.amalm9479.coderswag.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var  adapter : CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryAdapter(this, DataService.categories)
        catagoryListView.adapter = adapter
    }

}