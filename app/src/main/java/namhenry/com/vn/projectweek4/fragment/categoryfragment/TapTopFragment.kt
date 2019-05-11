package namhenry.com.vn.projectweek4.fragment.categoryfragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_tab_top.*
import namhenry.com.vn.project_week4.R
import namhenry.com.vn.projectweek4.adapter.RecyclerViewMain2Adapter
import namhenry.com.vn.projectweek4.model.ItemFragmentMain2

class TapTopFragment : Fragment() {

    private lateinit var listItemOfFragmentMain2: MutableList<ItemFragmentMain2>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tab_top, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView()
    }

    fun recyclerView() {
        listItemOfFragmentMain2 = mutableListOf()
        recyclerview_item_fragment_main2.layoutManager = LinearLayoutManager(context)
        for (i in 0..6) {
            listItemOfFragmentMain2.add(ItemFragmentMain2())
        }
        val adapter = RecyclerViewMain2Adapter(listItemOfFragmentMain2)
        recyclerview_item_fragment_main2.adapter = adapter
    }


}
