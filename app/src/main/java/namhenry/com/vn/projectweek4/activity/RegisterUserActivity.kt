package namhenry.com.vn.projectweek4.activity

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.action_bar.*
import kotlinx.android.synthetic.main.activity_register__user.*
import namhenry.com.vn.project_week4.R
import android.text.Editable
import android.text.TextWatcher
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import namhenry.com.vn.projectweek4.common.Constant
import namhenry.com.vn.projectweek4.common.Constant.REQUEST_CODE
import namhenry.com.vn.projectweek4.utills.SharePrefs
import namhenry.com.vn.projectweek4.utills.openActivity
import namhenry.com.vn.projectweek4.utills.showAlertDialog
import java.text.SimpleDateFormat
import java.util.*

class RegisterUserActivity : AppCompatActivity() {
    var spinner: Spinner? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register__user)

        tvSave.setOnClickListener {
            save()
        }
        tvDateOfBirth.setOnClickListener {
            chooseDOB()
        }
        imgRegisterUser.setOnClickListener {
            chooseImage()
        }

        spinnerOnClick()
    }


    private fun spinnerOnClick() {

        spinner = this.spRegisterUser
        val adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.number_child))
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner!!.adapter = adapter
        spRegisterUser.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                SharePrefs().getInstance().put(Constant.KEY_POSITION_SPINNER, position)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Code to perform some action when nothing is selected
            }
        }
    }

    private fun save() {
        val userName = edUserName.text.toString().trim()
        val dateOfBirth = tvDateOfBirth.text.toString().trim()
        val profile = edProfileRegisterUser.text.toString().trim()
        when {
            userName.length > 10 -> tvOverQuantity.visibility = View.VISIBLE
            userName.isEmpty() -> {
                tvNullText.visibility = View.VISIBLE
                tvOverQuantity.visibility = View.GONE
                tvNotChooseDate.visibility = View.VISIBLE
            }
            profile.length > 500 -> this@RegisterUserActivity.showAlertDialog(
                resources.getString(R.string.Enter_the_number_of_characters_too)
            )
            dateOfBirth.isEmpty() -> {
                tvNotChooseDate.visibility = View.VISIBLE

            }
            else -> openActivity(this, RegisterChildActivity())
        }
        edUserName.addTextChangedListener(userNameUserWatcher)
    }

    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    private fun chooseDOB() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val currentDay = "$year/${month + 1}/$day"
        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, _year, monthOfYear, dayOfMonth ->
            val dayOnCalendar = "$_year/${monthOfYear + 1}/$dayOfMonth"
            val sdf = SimpleDateFormat("dd/MM/yyyy")
            val dateToDay = sdf.parse(currentDay)
            val dateUserPick = sdf.parse(dayOnCalendar)
            when {
                dateUserPick.after(dateToDay) -> {
                    tvDateOfBirth.text = ""
                    tvChooseFutureDate.visibility = View.VISIBLE
                    tvNotChooseDate.visibility = View.GONE
                }
                dateUserPick.before(dateToDay) -> {
                    tvChooseFutureDate.visibility = View.GONE
                    tvDateOfBirth.text = "$_year/${(monthOfYear + 1)}/$dayOfMonth"
                }
                dateUserPick == dateToDay -> {
                    tvChooseFutureDate.visibility = View.GONE
                    tvDateOfBirth.text = "$_year/${(monthOfYear + 1)}/$dayOfMonth"
                }
            }
        }, year, month, day)
        dpd.show()
        tvDateOfBirth.addTextChangedListener(dateOfBirthUserWatcher)
    }

    private val userNameUserWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable) {
            if (s.isEmpty()) {
                tvNullText.visibility = View.VISIBLE
                tvOverQuantity.visibility = View.GONE
            } else {

                tvNullText.visibility = View.GONE
            }
        }
    }

    private val dateOfBirthUserWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable) {
            if (s.isEmpty()) {
                tvNotChooseDate.visibility = View.VISIBLE
            } else {
                tvNotChooseDate.visibility = View.GONE
            }
        }
    }

    private fun chooseImage() {

        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(
            Intent.createChooser(intent, "Select Picture"),
            REQUEST_CODE
        )

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != RESULT_OK) {
            return
        }
        if (requestCode == REQUEST_CODE) {

            if (data != null) {
                imgRegisterUser.setImageURI(data.data)
            }
        }
    }
}
