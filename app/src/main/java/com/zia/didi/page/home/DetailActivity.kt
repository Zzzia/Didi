package com.zia.didi.page.home

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zia.didi.R
import com.zia.didi.page.map.MapActivity
import com.zia.toastex.ToastEx
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
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
}
