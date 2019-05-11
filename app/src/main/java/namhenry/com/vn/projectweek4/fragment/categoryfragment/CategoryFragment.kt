package namhenry.com.vn.projectweek4.fragment.categoryfragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_category.*
import namhenry.com.vn.project_week4.R
import namhenry.com.vn.projectweek4.adapter.TabLayoutViewpageMain2Adapter

class CategoryFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = TabLayoutViewpageMain2Adapter(childFragmentManager)
        adapter.addFragments(TapTopFragment(),"Top")
        adapter.addFragments(TapTopFragment(),"ADHD")
        adapter.addFragments(TapTopFragment(),"履歴")
        adapter.addFragments(TapTopFragment(),"自閉症")
        adapter.addFragments(TapTopFragment(),"染色体異常")
        adapter.addFragments(TapTopFragment(),"その他")
        adapter.addFragments(TapTopFragment(),"学習障害")
        adapter.addFragments(TapTopFragment(),"精神発達遅滞")
        viewpage_main2.adapter=adapter
        taplayout_main2.setupWithViewPager(viewpage_main2)

    }


}
