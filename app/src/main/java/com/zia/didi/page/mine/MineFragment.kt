package com.zia.didi.page.mine

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zia.didi.R
import com.zia.didi.page.login.LoginActivity
import com.zia.didi.util.UserHelper
import kotlinx.android.synthetic.main.fragment_mine.*

class MineFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mine_loginOut.setOnClickListener {
            UserHelper.clear(context)
            startActivity(Intent(context, LoginActivity::class.java))
            activity?.finish()
        }
    }
}
