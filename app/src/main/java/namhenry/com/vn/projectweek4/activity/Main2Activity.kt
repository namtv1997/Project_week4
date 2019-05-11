package namhenry.com.vn.projectweek4.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main2.*
import namhenry.com.vn.project_week4.R
import namhenry.com.vn.projectweek4.fragment.categoryfragment.CategoryFragment
import namhenry.com.vn.projectweek4.fragment.MyPageFragment
import namhenry.com.vn.projectweek4.fragment.NoticeFragment
import namhenry.com.vn.projectweek4.fragment.TimeLineFragment
import namhenry.com.vn.projectweek4.utills.switchFragment

class Main2Activity : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.navigation_category -> {
                switchFragment(CategoryFragment())
            }
            R.id.navigation_timeline -> {
                switchFragment(TimeLineFragment())
            }
            R.id.navigation_mypage -> {
                switchFragment(MyPageFragment())
            }
            R.id.navigation_notice -> {
                switchFragment(NoticeFragment())
            }
            else -> {
                switchFragment(CategoryFragment())
            }
        }
        return true

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        bottom_navigation_main2.setOnNavigationItemSelectedListener(this)
        bottom_navigation_main2.selectedItemId = R.id.navigation_category
    }

}
