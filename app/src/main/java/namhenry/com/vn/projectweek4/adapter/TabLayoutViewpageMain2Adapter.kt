package namhenry.com.vn.projectweek4.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter


class TabLayoutViewpageMain2Adapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
    private val mfragmentList: MutableList<Fragment> = ArrayList()
    private val mfragmentTitle: MutableList<String> = ArrayList()

    fun addFragments(fragment: Fragment, fragmentTitle: String) {
        mfragmentList.add(fragment)
        mfragmentTitle.add(fragmentTitle)
    }

    override fun getItem(p0: Int): Fragment {
        return mfragmentList[p0]
    }

    override fun getCount(): Int {
        return mfragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mfragmentTitle[position]
    }
}