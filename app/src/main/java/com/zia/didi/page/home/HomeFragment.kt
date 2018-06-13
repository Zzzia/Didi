package com.zia.didi.page.home


import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Pair
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.zia.didi.R
import com.zia.didi.util.Java2Kotlin
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var adapter: Adapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = Adapter()
        home_rv.adapter = adapter
        home_rv.layoutManager = LinearLayoutManager(context)
        adapter.notifyDataSetChanged()
    }

    class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_help, parent, false)
            return DataHolder(view)
        }

        override fun getItemCount(): Int {
            return 10
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when (holder) {
                is DataHolder -> {
                    holder.itemView.setOnClickListener {
                        val context = holder.itemView.context
                        val intent = Intent(context, DetailActivity::class.java)
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            val p = arrayListOf<Pair<View, String>>(Pair.create(holder.itemView, "card"),
                                    Pair.create(holder.name, "name"),
                                    Pair.create(holder.image, "image"),
                                    Pair.create(holder.introduce, "introduce"),
                                    Pair.create(holder.sex, "sex"),
                                    Pair.create(holder.distance,"distance"))
                            val text = holder.introduce.text
                            holder.introduce.text = ""
                            val options = ActivityOptions.makeSceneTransitionAnimation(context as Activity?, *Java2Kotlin.getPairs(p))
                            context.startActivity(intent, options.toBundle())
                            holder.introduce.text = text
                        } else {
                            context.startActivity(intent)
                        }
                    }
                }
            }
        }

        class DataHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val image = itemView.findViewById<ImageView>(R.id.item_home_rv_imageView)
            val name = itemView.findViewById<TextView>(R.id.item_home_rv_name)
            val introduce = itemView.findViewById<TextView>(R.id.item_home_rv_normal_introduce)
            val location = itemView.findViewById<TextView>(R.id.item_home_rv_normal_location)
            val distance = itemView.findViewById<TextView>(R.id.item_home_rv_distance)
            val price = itemView.findViewById<TextView>(R.id.item_home_rv_normal_price)
            val sex = itemView.findViewById<ImageView>(R.id.item_home_rv_sex)
        }
    }
}
