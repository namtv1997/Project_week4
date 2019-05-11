package namhenry.com.vn.projectweek4.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import namhenry.com.vn.project_week4.R
import android.text.TextUtils
import android.util.Log
import namhenry.com.vn.project_week4.R.string.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        onClick()

    }

    private fun isValidEmail(target: String): Boolean {
        return if (TextUtils.isEmpty(target)) {
            false
        } else {
            android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }

    fun onClick() {
        btnlogin.setOnClickListener {
            val email = edt_mail.text.toString().trim()
            val pass = edt_pass.text.toString()
            if (email.isEmpty()) {
                Toast.makeText(this, tv_email_empty, Toast.LENGTH_LONG).show()
            } else if (!isValidEmail(email)) {
                Toast.makeText(this, tv_email_wrong, Toast.LENGTH_LONG).show()
            } else if (pass.isEmpty()) {
                Toast.makeText(this, tv_pass_empty, Toast.LENGTH_LONG).show()
            } else if (pass.contentEquals("admin")) {
                Toast.makeText(this, tv_pass_wrong, Toast.LENGTH_LONG).show()
            } else{

            }
        }
    }

}



