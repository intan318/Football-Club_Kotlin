package com.example.intanyoshanaoewen.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.intanyoshanaoewen.footballclub.R.id.desc_text
import org.jetbrains.anko.*
import java.nio.file.Files.find

class DescActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DescUI().setContentView(this)

        val img = intent.getIntExtra("IMAGE",0)
        val name = intent.getStringExtra("NAME")
        val desc = intent.getStringExtra("DESC")

        val nameDesc = find<TextView>(R.id.name_desc)
        val imgDesc = find<ImageView>(R.id.image_desc)
        val textDesc = find<TextView>(R.id.desc_text)

        nameDesc.text = name
        Glide.with(this).load(img).into(imgDesc)
        textDesc.text = desc
    }

    class DescUI : AnkoComponent<DescActivity> {
        override fun createView(ui: AnkoContext<DescActivity>) = with(ui) {
            relativeLayout {
                padding = dip(20)

                imageView {
                    id = R.id.image_desc
                }.lparams {
                    width = dip(120)
                    height = dip(120)
                    centerHorizontally()
                }

                textView {
                    textSize = sp(14).toFloat()
                    id = R.id.name_desc
                }.lparams {
                    centerHorizontally()
                    width = wrapContent
                    height = wrapContent
                    below(R.id.image_desc)
                }

                textView {
                    textSize = sp(12).toFloat()
                    id = R.id.desc_text
                }.lparams {
                    centerHorizontally()
                    width = wrapContent
                    height = wrapContent
                    below(R.id.name_desc)
                }
            }
        }
    }
}
