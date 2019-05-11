package namhenry.com.vn.projectweek4.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import namhenry.com.vn.project_week4.R
import namhenry.com.vn.projectweek4.model.ItemFragmentMain2

class RecyclerViewMain2Adapter(private var itemListFragmentMain2:MutableList<ItemFragmentMain2>):RecyclerView.Adapter<RecyclerViewMain2Adapter.ItemFragmentMain2ViewHolder>() {
    private lateinit var mContext:Context
    private lateinit var view:View

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ItemFragmentMain2ViewHolder {
        mContext=p0.context
        view=LayoutInflater.from(mContext).inflate( R.layout.item_fragment_main2,p0,false)
        return ItemFragmentMain2ViewHolder(view)
    }

    override fun getItemCount(): Int = itemListFragmentMain2.size


    override fun onBindViewHolder(p0: ItemFragmentMain2ViewHolder, p1: Int) {

    }

    inner class ItemFragmentMain2ViewHolder(view:View): RecyclerView.ViewHolder(view) {
        init {

        }
    }
}