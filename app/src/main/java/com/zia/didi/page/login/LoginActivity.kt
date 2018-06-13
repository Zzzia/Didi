package com.zia.didi.page.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zia.didi.R
import com.zia.didi.page.MainActivity
import com.zia.didi.util.UserHelper
import com.zia.toastex.ToastEx
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login_toRegister.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }
        login_submitButton.setOnClickListener {
            val username = login_username.text.toString()
            val password = login_password.text.toString()
            if (username.isEmpty() || password.isEmpty()) {
                ToastEx.warning(this@LoginActivity, "不能为空").show()
                login_submitButton.reset()
                return@setOnClickListener
            }
            Thread(Runnable {
                login_submitButton.setProgress(0)
                UserHelper.saveData(this@LoginActivity, username, password)
                Thread.sleep(1000)
                runOnUiThread { login_submitButton.doResult(true) }
            }).start()
        }
        login_submitButton.setOnResultEndListener {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            this@LoginActivity.finish()
        }
    }
}
