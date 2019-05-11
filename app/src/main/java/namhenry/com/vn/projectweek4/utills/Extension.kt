package namhenry.com.vn.projectweek4.utills

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import namhenry.com.vn.project_week4.R


fun Fragment.switchFragment( fragment: Fragment,replace:Int= R.id.framelayout_activity_main2){
    val name: String = fragment.javaClass.name
    val ft : FragmentTransaction = activity!!.supportFragmentManager.beginTransaction()
    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
    ft.replace(replace, fragment)
    ft.addToBackStack(name)
    ft.commit()
}

fun AppCompatActivity.switchFragment(fragment: Fragment, replace:Int = R.id.framelayout_activity_main2){
    val name: String = fragment.javaClass.name
    val ft : FragmentTransaction = supportFragmentManager.beginTransaction()
    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
    ft.replace(replace, fragment)
    ft.addToBackStack(name)
    ft.commit()
}

fun Context.showAlertDialog(message1: String) {
    val builder: AlertDialog.Builder = AlertDialog.Builder(this)
    builder.setTitle("Error")
    builder.setMessage(message1)
    builder.setNegativeButton("OK") { dialog, _ ->
        dialog.dismiss()
    }

    val alertDialog: AlertDialog = builder.create()
    alertDialog.show()

}

fun Context.showMessage( message:String = "OK"){
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}
fun openActivity(context: Context,activity: AppCompatActivity){
    val intent = Intent(context, activity::class.java)
    context.startActivity(intent)
}

