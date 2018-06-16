package com.zia.didi.page

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.yanzhenjie.permission.AndPermission
import com.zia.didi.R
import com.zia.didi.page.login.LoginActivity
import com.zia.didi.util.UserHelper
import com.zia.toastex.ToastEx

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        AndPermission.with(this)
                .runtime()
                .permission(Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.READ_PHONE_STATE)
                .onGranted { permissions ->
                    if (UserHelper.checkLogin(this@StartActivity)) {
                        startActivity(Intent(this@StartActivity, MainActivity::class.java))
                    } else {
                        startActivity(Intent(this@StartActivity, LoginActivity::class.java))
                    }
                    finish()
                }
                .onDenied { permissions ->
                    ToastEx.warning(this@StartActivity, "请确认定位权限").show()
                    Log.e("warning", permissions.toString())
                    finish()
                }
                .start()


    }
}
