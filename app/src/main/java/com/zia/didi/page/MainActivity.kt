package com.zia.didi.page

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Pair
import android.view.MenuItem
import android.view.View
import com.zia.didi.R
import com.zia.didi.page.home.HomeFragment
import com.zia.didi.page.mine.MineFragment
import com.zia.didi.page.publish.PublishActivity
import com.zia.didi.util.Java2Kotlin
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

    override fun onResume() {
        super.onResume()
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
                val intent = Intent(this@MainActivity, PublishActivity::class.java)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    val p = arrayListOf<Pair<View, String>>(Pair.create(main_nav, "nav"))
                    val options = ActivityOptions.makeSceneTransitionAnimation(this@MainActivity, *Java2Kotlin.getPairs(p))
                    this@MainActivity.startActivity(intent, options.toBundle())
                } else {
                    this@MainActivity.startActivity(intent)
                }
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
