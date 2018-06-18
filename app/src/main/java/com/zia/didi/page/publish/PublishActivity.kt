package com.zia.didi.page.publish

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.zia.didi.R
import kotlinx.android.synthetic.main.activity_publish.*

class PublishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publish)
        publish_root.setOnClickListener { this@PublishActivity.finish() }
    }
}
