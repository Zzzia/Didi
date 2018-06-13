package com.zia.didi.page

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zia.didi.R
import com.zia.didi.page.login.LoginActivity
import com.zia.didi.util.UserHelper

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        if (UserHelper.checkLogin(this@StartActivity)){
            startActivity(Intent(this@StartActivity, MainActivity::class.java))
        }else{
            startActivity(Intent(this@StartActivity, LoginActivity::class.java))
        }
        finish()

    }
}
