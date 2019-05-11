package namhenry.com.vn.projectweek4.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

import kotlinx.android.synthetic.main.activity_main.*
import namhenry.com.vn.project_week4.R
import namhenry.com.vn.projectweek4.fragment.FirstScreenThreeFragment
import namhenry.com.vn.projectweek4.fragment.FragmentFirstScreenFour
import namhenry.com.vn.projectweek4.fragment.Fragment_FirstScreen_One
import namhenry.com.vn.projectweek4.fragment.Fragment_FirstScreen_Two
import namhenry.com.vn.projectweek4.utills.openActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAdapter()
        onClick()
    }

    class MyViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
        private val fragmentList: MutableList<Fragment> = ArrayList()
        override fun getItem(p0: Int): Fragment {
            return fragmentList[p0]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment(fragment: Fragment) {
            fragmentList.add(fragment)
        }

    }

    fun setAdapter() {
        val adapter = MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(Fragment_FirstScreen_One())
        adapter.addFragment(Fragment_FirstScreen_Two())
        adapter.addFragment(FirstScreenThreeFragment())
        adapter.addFragment(FragmentFirstScreenFour())
        viewpage.adapter = adapter
        circleIndicator.setViewPager(viewpage)
    }

    fun onClick() {
        tvloginFirstScreen.setOnClickListener {
            openActivity(this, LoginActivity())
        }
        btnRegisterUser.setOnClickListener {

            openActivity(this, RegisterUserActivity())
        }
    }
}
