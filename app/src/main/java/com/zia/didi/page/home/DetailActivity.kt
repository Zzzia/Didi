package com.zia.didi.page.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zia.didi.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        detail_root.setOnClickListener {
            this@DetailActivity.finish()
        }
    }
}
