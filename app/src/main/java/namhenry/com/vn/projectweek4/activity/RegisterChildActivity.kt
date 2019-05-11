package namhenry.com.vn.projectweek4.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.action_bar.*
import kotlinx.android.synthetic.main.activity_register_child.*
import namhenry.com.vn.project_week4.R
import namhenry.com.vn.projectweek4.common.Constant
import namhenry.com.vn.projectweek4.model.ItemChild
import namhenry.com.vn.projectweek4.utills.RegisterChildAdapter
import namhenry.com.vn.projectweek4.utills.SharePrefs
import namhenry.com.vn.projectweek4.utills.openActivity
import namhenry.com.vn.projectweek4.utills.showMessage


class RegisterChildActivity : AppCompatActivity() {
    private lateinit var listItemOfChild: MutableList<ItemChild>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_child)
        recyclerView()
    }

    private fun recyclerView(){

        listItemOfChild = mutableListOf()

        val numberChild = SharePrefs().getInstance()[Constant.KEY_POSITION_SPINNER, Int::class.java]


        recyclerViewChild.layoutManager = LinearLayoutManager(this)
        if (numberChild != null) {
            for (i in 0..numberChild) {
                listItemOfChild.add(ItemChild())
            }

        }

        val adapter = RegisterChildAdapter(listItemOfChild)
        recyclerViewChild.adapter = adapter

        tvSave.setOnClickListener {
            if (adapter.check()){
           openActivity(this,Main2Activity())
            } else {
                showMessage("loi")
            }
        }
    }





}
