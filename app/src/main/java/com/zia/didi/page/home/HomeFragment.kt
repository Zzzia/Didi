package com.zia.didi.page.home


import android.annotation.SuppressLint
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
import com.bumptech.glide.Glide
import com.zia.didi.R
import com.zia.didi.bean.Information
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
        initData()
    }

    class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        private var informations = ArrayList<Information>()

        fun fresh(informations: ArrayList<Information>) {
            this.informations = informations
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_help, parent, false)
            return DataHolder(view)
        }

        override fun getItemCount(): Int {
            return informations.size
        }

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when (holder) {
                is DataHolder -> {
                    val information = informations[position]
                    holder.itemView.setOnClickListener {
                        val context = holder.itemView.context
                        val intent = Intent(context, DetailActivity::class.java)
                        intent.putExtra("information",information)
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            val p = arrayListOf<Pair<View, String>>(Pair.create(holder.itemView, "card"),
                                    Pair.create(holder.name, "name"),
                                    Pair.create(holder.image, "image"),
                                    Pair.create(holder.introduce, "introduce"),
                                    Pair.create(holder.sex, "sex"),
                                    Pair.create(holder.distance, "distance"))
                            val text = holder.introduce.text
                            holder.introduce.text = ""
                            val options = ActivityOptions.makeSceneTransitionAnimation(context as Activity?, *Java2Kotlin.getPairs(p))
                            context.startActivity(intent, options.toBundle())
                            holder.introduce.text = text
                        } else {
                            context.startActivity(intent)
                        }
                    }
                    holder.introduce.text = information.introduce
                    holder.distance.text = information.distance
                    holder.location.text = information.location
                    holder.name.text = information.name
                    holder.price.text = information.price + "积分"
                    if (information.sex == "男") {
                        holder.sex.setImageResource(R.mipmap.male)
                    } else {
                        holder.sex.setImageResource(R.mipmap.female)
                    }
                    if (information.image.isNotEmpty()) {
                        Glide.with(holder.itemView.context).load(information.image).into(holder.image)
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

    private fun initData() {
        val list = ArrayList<Information>()
        val information1 = Information()
        val information2 = Information()
        val information3 = Information()
        val information4 = Information()
        information1.image = "http://zzzia.net/image/head.png"
        information1.distance = "438m"
        information1.introduce = "食堂二楼求伞友..."
        information1.location = "兴业苑食堂二楼"
        information1.name = "zia"
        information1.price = "8"
        information1.sex = "男"
        information2.image = "http://zzzia.net/image/icon.png"
        information2.distance = "657m"
        information2.introduce = "下了自习居然下雨了！！"
        information2.location = "三教门口"
        information2.name = "滴滴，学生卡"
        information2.price = "10"
        information2.sex = "女"
        information3.image = "http://lc-umvcn1hd.cn-n1.lcfile.com/urB1BCAS5GvIjim9efTUkVL0vgDpemOvMT5c4AQB"
        information3.distance = "773m"
        information3.introduce = "求伞友，么么哒"
        information3.location = "四教"
        information3.name = "重邮周冬雨"
        information3.price = "5"
        information3.sex = "女"
        information4.image = "http://zzzia.net/image/alma.png"
        information4.distance = "1328m"
        information4.introduce = "寻找一个能送伞的妹子"
        information4.location = "新校门"
        information4.name = "zia"
        information4.price = "20"
        information4.sex = "男"
        list.add(information1)
        list.add(information2)
        list.add(information3)
        list.add(information4)
        adapter.fresh(list)
    }
}
