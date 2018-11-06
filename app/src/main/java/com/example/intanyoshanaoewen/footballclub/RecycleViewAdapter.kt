package com.example.intanyoshanaoewen.footballclub

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

/**
 * Created by Intan Yoshana Oewen on 02/11/2018.
 */
class RecycleViewAdapter(private val context: Context, private val items: List<Item>, private val listener: (Item) -> Unit) :
        RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>()
{
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder
        {
                return ViewHolder(ItemViewUI().createView(AnkoContext.create(parent.context)))
        }
        override fun onBindViewHolder(holder: ViewHolder, position: Int)
        {
                holder.bindItem(items[position],context,listener)
        }

        override fun getItemCount(): Int = items.size

        class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
            LayoutContainer {

            val name = containerView.find<TextView>(R.id.name)
            val image = containerView.find<ImageView>(R.id.image)

            fun bindItem(items: Item, context: Context, listener: (Item) -> Unit) {
                name.text = items.name
                items.image?.let { Glide.with(context).load(it).into(image) }
                containerView.setOnClickListener{listener(items)}
            }
        }
    }

    class ItemViewUI : AnkoComponent<Context> {
        override fun createView (ui: AnkoContext<Context>): View = with (ui) {
            return cardView {
                layoutParams = android.widget.FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT).apply {
                    margin = dip(10)
                }
                relativeLayout {
                    padding = dip(16)
                    imageView {

                        id = R.id.image
                    }.lparams {
                        centerHorizontally()
                        width = dip(70)
                        height = dip(70)
                        setMargins(0, 0, dip(16), 0)
                    }
                    textView {

                        textSize = sp(8).toFloat()
                        id = R.id.name

                    }.lparams {
                        centerHorizontally()
                        width = wrapContent
                        height = wrapContent
                        below(R.id.image)
                    }
                }

            }
    }
}