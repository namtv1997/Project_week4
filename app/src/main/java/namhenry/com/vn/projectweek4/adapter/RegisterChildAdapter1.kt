package namhenry.com.vn.projectweek4.utills

import android.app.DatePickerDialog
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.item_register_child.view.*
import namhenry.com.vn.project_week4.R
import namhenry.com.vn.projectweek4.model.ItemChild
import java.text.SimpleDateFormat
import java.util.*


class RegisterChildAdapter(private var childListItems: MutableList<ItemChild>) :
    RecyclerView.Adapter<RegisterChildAdapter.ChildViewHolder>() {
    private var checkSickADHD = true
    private var checkSickLD = false
    private var checkSickMR = false
    private var checkSickAutism = false
    private var checkSickChromosomal_abnormalities = false
    private var checkSickDifferent = false

    private var mExpandedPosition = 1
    private lateinit var mContext: Context
    private lateinit var view: View

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RegisterChildAdapter.ChildViewHolder {
        mContext = parent.context
        view = LayoutInflater.from(mContext).inflate(R.layout.item_register_child, parent, false)
        return ChildViewHolder(view)
    }

    override fun getItemCount(): Int = childListItems.size

    override fun onBindViewHolder(holder: RegisterChildAdapter.ChildViewHolder, position: Int) {
        holder.itemView.title_expandale.text = "${holder.adapterPosition + 1}人のこどものプロフィール"
        holder.fillData()
    }

    fun check(): Boolean {
        val userNameChild = view.edUserNameChild.text.toString().trim()
        val dateOfBirthChild = view.tvDateOfBirthChild.text.toString().trim()
        val edProfileRegisterUserChild = view.edProfileRegisterChild.text.toString().trim()
        if (userNameChild.length > 10) {
            view.tvOverQuantityChild.visibility = View.VISIBLE
            return false
        }
        if (userNameChild.isEmpty()) {
            view.tvNullTextChild.visibility = View.VISIBLE
            view.tvOverQuantityChild.visibility = View.GONE
            view.tvNotChooseDateChild.visibility = View.VISIBLE
            return false
        }

        if(dateOfBirthChild.isEmpty()){
            view.tvNotChooseDateChild.visibility = View.VISIBLE
            return false
        }

        if(edProfileRegisterUserChild.length > 500) {
            mContext.showAlertDialog(
                mContext.resources.getString(R.string.Enter_the_number_of_characters_too)
            )
            return false
        }

        if (!checkSickADHD && !checkSickMR && !checkSickLD &&!checkSickDifferent && !checkSickChromosomal_abnormalities && !checkSickAutism){
            mContext.showAlertDialog(mContext.resources.getString(R.string.registerChild_diseases_null))
            return false
        }

        return true
    }



    inner class ChildViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        init {
            initViewListener()
            checkSick()
        }

        private fun checkSick(){
            itemView.cbADHD.setOnCheckedChangeListener { _: CompoundButton?, p1: Boolean ->
                checkSickADHD = p1
            }
            itemView.cbAutium.setOnCheckedChangeListener { _: CompoundButton?, p1: Boolean ->
                checkSickAutism = p1
            }
            itemView.cbChromosomal.setOnCheckedChangeListener { _: CompoundButton?, p1: Boolean ->
                checkSickMR = p1
            }
            itemView.cbDifferent.setOnCheckedChangeListener { _: CompoundButton?, p1: Boolean ->
                checkSickLD = p1
            }
            itemView.cbLD.setOnCheckedChangeListener { _: CompoundButton?, p1: Boolean ->
                checkSickDifferent = p1
            }
            itemView.cbMR.setOnCheckedChangeListener { _: CompoundButton?, p1: Boolean ->
                checkSickChromosomal_abnormalities = p1
            }
        }

        private fun initViewListener() {
            itemView.btnSaveAndContinue.setOnClickListener {
                val userNameChild = view.edUserNameChild.text.toString().trim()
                val dateOfBirthChild = view.tvDateOfBirthChild.text.toString().trim()
                val edProfileRegisterUserChild = view.edProfileRegisterChild.text.toString().trim()
                if (userNameChild.length > 10) {
                    view.tvOverQuantityChild.visibility = View.VISIBLE

                }else if (userNameChild.isEmpty()) {
                    view.tvNullTextChild.visibility = View.VISIBLE
                    view.tvOverQuantityChild.visibility = View.GONE
                    view.tvNotChooseDateChild.visibility = View.VISIBLE

                }else if(dateOfBirthChild.isEmpty()){
                    view.tvNotChooseDateChild.visibility = View.VISIBLE

                }else if(edProfileRegisterUserChild.length > 500) {
                    mContext.showAlertDialog(
                        mContext.resources.getString(R.string.Enter_the_number_of_characters_too)
                    )

                }
            }
            itemView.tvDateOfBirthChild.setOnClickListener {
                val c = Calendar.getInstance()
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)
                val currentDay = "$year/${month + 1}/$day"
                val dpd =
                    DatePickerDialog(mContext, DatePickerDialog.OnDateSetListener { _, _year, monthOfYear, dayOfMonth ->
                        val dayOnCalendar = "$_year/${monthOfYear + 1}/$dayOfMonth"
                        val sdf = SimpleDateFormat("dd/MM/yyyy")
                        val dateToDay = sdf.parse(currentDay)
                        val dateUserPick = sdf.parse(dayOnCalendar)
                        when {
                            dateUserPick.after(dateToDay) -> {
                                itemView.tvDateOfBirthChild.text = ""
                                itemView.tvChooseFutureDateChild.visibility = View.VISIBLE
                                itemView.tvNotChooseDateChild.visibility = View.GONE
                            }
                            dateUserPick.before(dateToDay) -> {
                                itemView.tvChooseFutureDateChild.visibility = View.GONE
                                itemView.tvDateOfBirthChild.text =
                                        ("$_year/${(monthOfYear + 1)}/$dayOfMonth").toString()
                            }
                            dateUserPick == dateToDay -> {
                                itemView.tvChooseFutureDateChild.visibility = View.GONE
                                itemView.tvDateOfBirthChild.text = "$_year/${(monthOfYear + 1)}/$dayOfMonth"
                            }
                        }
                    }, 2014, 4, 5)
                dpd.show()
            }

            itemView.tvDateOfBirthChild.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(p0: Editable?) {
                    if (p0!!.isEmpty()) {
                        itemView.tvNotChooseDateChild.visibility = View.VISIBLE
                    } else {
                        itemView. tvNotChooseDateChild.visibility = View.GONE
                    }
                }
            })

            itemView.edUserNameChild.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(p0: Editable?) {
                    if (p0!!.isEmpty()) {
                        itemView.tvNullTextChild.visibility = View.VISIBLE
                        itemView.tvOverQuantityChild.visibility = View.GONE
                    } else {

                        itemView.tvNullTextChild.visibility = View.GONE
                    }
                }
            })

            itemView.title_expandale.setOnClickListener {
                mExpandedPosition = if (adapterPosition == mExpandedPosition) -1 else adapterPosition
                notifyDataSetChanged()
            }

            itemView.rdGenderChild.setOnCheckedChangeListener { _, checkedId ->
                when (checkedId) {
                    R.id.rbMale -> {
                        mContext.showMessage(itemView.rbMale.text.toString())
                    }
                    R.id.rbFeMale -> {
                        mContext.showMessage(itemView.rbFeMale.text.toString())
                    }
                    R.id.rbDifferent -> {
                        mContext.showMessage(itemView.rbDifferent.text.toString())
                    }
                }
            }


        }

        fun fillData() {
            val isExpanded = (adapterPosition == mExpandedPosition)
            itemView.itemChild.visibility = if (isExpanded) View.VISIBLE else View.GONE
            itemView.img_up.visibility=  if (isExpanded) View.VISIBLE else View.GONE
            itemView.img_down.visibility=  if (isExpanded) View.GONE else View.VISIBLE
        }
    }


}