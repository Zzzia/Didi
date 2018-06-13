package com.zia.didi.page

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.zia.didi.R
import com.zia.didi.page.home.HomeFragment
import com.zia.didi.page.mine.MineFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var homeFragment: HomeFragment
    private lateinit var mineFragment: MineFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        homeFragment = HomeFragment()
        mineFragment = MineFragment()
        main_nav.setOnNavigationItemSelectedListener(this@MainActivity)
        transaction(homeFragment)
    }

    private fun transaction(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_frame, fragment)
        transaction.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                transaction(homeFragment)
                return true
            }
            R.id.publish -> {

                return true
            }
            R.id.mine -> {
                transaction(mineFragment)
                return true
            }
        }
        return false
    }
}
