package com.zia.didi.page.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zia.didi.R
import com.zia.toastex.ToastEx
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        register_submitButton.setOnClickListener {
            val username = register_username.text.toString()
            val password = register_password.text.toString()
            val nickname = register_nickname.text.toString()
            if (username.isEmpty() || password.isEmpty() || nickname.isEmpty()) {
                ToastEx.warning(this@RegisterActivity, "不能为空").show()
                register_submitButton.reset()
                return@setOnClickListener
            }
            register_submitButton.setProgress(0)
            Thread(Runnable {
                Thread.sleep(1000)
                runOnUiThread { register_submitButton.doResult(true) }
            }).start()
        }
        register_submitButton.setOnResultEndListener {
            this@RegisterActivity.finish()
        }
    }
}
