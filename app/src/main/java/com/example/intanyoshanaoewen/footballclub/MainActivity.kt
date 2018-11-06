package com.example.intanyoshanaoewen.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor


class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RecycleViewAdapter (this, items) {
            val toast = Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT)
            toast.show()

            startActivity(intentFor<DescActivity>(
                    "NAME" to it.name, "IMAGE" to it.image, "DESC" to it.desc))
        }


    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val desc = resources.getStringArray(R.array.club_desc)
        items.clear()
        for (i in name.indices)
        {
            items.add(Item(name[i], image.getResourceId(i, 0), desc[i]))
        }
        image.recycle()
    }
}
