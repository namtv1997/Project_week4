package namhenry.com.vn.projectweek4.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import namhenry.com.vn.project_week4.R

class Fragment_FirstScreen_Two : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_firstscreen_two,container,false)
    }


}
