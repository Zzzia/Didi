package com.zia.didi.page.home

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.zia.didi.R
import com.zia.didi.bean.Information
import com.zia.didi.page.map.MapActivity
import com.zia.toastex.ToastEx
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initData()
        detail_help.setOnClickListener {
            ToastEx.success(this@DetailActivity,"啵啵~").show()
            val intent = Intent(this@DetailActivity,MapActivity::class.java)
            startActivity(intent)
            this@DetailActivity.finish()
        }
        detail_root.setOnClickListener {
            this@DetailActivity.finish()
        }
    }

    private fun initData(){
        val information = intent.getSerializableExtra("information") as Information
        detail_distance.text = information.distance
        detail_introduce.text = information.introduce
        detail_name.text = information.name
        if (information.sex == "男"){
            detail_sex.setImageResource(R.mipmap.male)
        }else{
            detail_sex.setImageResource(R.mipmap.female)
        }
        if (information.image.isNotEmpty()){
            Glide.with(this@DetailActivity).load(information.image).into(detail_image)
        }
    }
}
