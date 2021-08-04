package com.saifkhan.ripl.ui.fragments.residentFragment

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.saif.hiringproject.data.models.EducationModel
import com.saif.hiringproject.data.models.MartialStatusModel
import com.saif.hiringproject.data.models.OccupationModel
import com.saif.hiringproject.ui.fragments.SurveylocalityselectionFragment.adapter.EducationAdapter
import com.saif.hiringproject.ui.fragments.SurveylocalityselectionFragment.adapter.MaritalStatusAdapter
import com.saif.hiringproject.ui.fragments.SurveylocalityselectionFragment.adapter.OccupationAdapter
import com.saif.hiringproject.ui.fragments.onBoardingFragment.loginFragment.ResidentInformationViewModel
import com.saifkhan.ripl.BR
import com.saifkhan.ripl.R
import com.saifkhan.ripl.baseclasses.BaseFragment
import com.saifkhan.ripl.data.models.MasterModel
import com.saifkhan.ripl.databinding.FragmentResidentInformationBinding
import com.saifkhan.ripl.utils.ConstantUtilList
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_resident_information.*
import java.util.*


@AndroidEntryPoint
class ResidentInformationFragment :
    BaseFragment<FragmentResidentInformationBinding, ResidentInformationViewModel>() {


    override val layoutId: Int
        get() = R.layout.fragment_resident_information
    override val viewModel: Class<ResidentInformationViewModel>
        get() = ResidentInformationViewModel::class.java
    override val bindingVariable: Int
        get() = BR.viewModel

    lateinit var occupationAdapter: OccupationAdapter
    lateinit var educationAdapter: EducationAdapter
    lateinit var maritalStatusAdapter: MaritalStatusAdapter


    val myCalendar = Calendar.getInstance()
    var selectedGender: Int = -1
    var selectedRadioBtn: ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.allItems.observe(this, androidx.lifecycle.Observer {
            Log.d("Item ", "${it.size}")
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intialising()
        clickListener()
    }

    @SuppressLint("SimpleDateFormat")
    private fun clickListener() {


        maritalStatusAdapter = MaritalStatusAdapter(
            ConstantUtilList.getMaritalStatus(),
            object : MaritalStatusAdapter.ClickItemListener {
                override fun onClicked(position: Int) {
                    val model: MartialStatusModel = ConstantUtilList.getMaritalStatus()[position]
                    tvMaritalStatus.setText(model.maritalStatusName.toString())
                    expandable_layout_marital_status.setExpanded(false, true)
                }

            })
        recyclerViewMaritalStatus.adapter = maritalStatusAdapter
        maritalStatusAdapter.notifyDataSetChanged()
        tvMaritalStatus.setOnClickListener {
            expandable_layout_marital_status.setExpanded(
                !expandable_layout_marital_status.isExpanded,
                true
            )
        }

        occupationAdapter = OccupationAdapter(
            ConstantUtilList.getOccupation(),
            object : OccupationAdapter.ClickItemListener {
                override fun onClicked(position: Int) {
                    val model: OccupationModel = ConstantUtilList.getOccupation()[position]
                    tvOccupation.setText(model.occName.toString())
                    expandable_layout_occupation.setExpanded(false, true)
                }

            })
        recyclerViewOccupation.adapter = occupationAdapter
        occupationAdapter.notifyDataSetChanged()
        tvOccupation.setOnClickListener {
            expandable_layout_occupation.setExpanded(!expandable_layout_occupation.isExpanded, true)
        }

        educationAdapter = EducationAdapter(
            ConstantUtilList.geteducation(),
            object : EducationAdapter.ClickItemListener {
                override fun onClicked(position: Int) {
                    val model: EducationModel = ConstantUtilList.geteducation()[position]
                    tvEducation.setText(model.educationName.toString())
                    expandable_layout_education.setExpanded(false, true)
                }

            })
        recyclerViewEducation.adapter = educationAdapter
        educationAdapter.notifyDataSetChanged()
        tvEducation.setOnClickListener {
            expandable_layout_education.setExpanded(!expandable_layout_education.isExpanded, true)

        }

        etDateOfBirth.setOnClickListener {

            val currentDateTime = Calendar.getInstance()
            val startYear = currentDateTime.get(Calendar.YEAR)
            val startMonth = currentDateTime.get(Calendar.MONTH)
            val startDay = currentDateTime.get(Calendar.DAY_OF_MONTH)


            DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { _, year, month, day ->
                    etDateOfBirth.setText("$year-${month + 1}-$day")
                },
                startYear,
                startMonth,
                startDay
            ).show()
        }


        btnSubmit.setOnClickListener {
            if (!TextUtils.isEmpty(etSerialNo.text.toString())) {
                if (!TextUtils.isEmpty(etNameOfPerson.text.toString())) {
                    if (!TextUtils.isEmpty(etFatherName.text.toString())) {
                        if (!TextUtils.isEmpty(etMotherName.text.toString())) {
                            if (!TextUtils.isEmpty(etAddress.text.toString())) {
                                if (!TextUtils.isEmpty(etMobileNumber.text.toString())) {
                                    if (!TextUtils.isEmpty(etDateOfBirth.text.toString())) {
                                        if (!TextUtils.isEmpty(etAgeInYears.text.toString())) {
                                            if (!TextUtils.isEmpty(tvMaritalStatus.text.toString())) {
                                                if (!TextUtils.isEmpty(tvEducation.text.toString())) {
                                                    if (!TextUtils.isEmpty(tvOccupation.text.toString())) {
                                                        if (!TextUtils.isEmpty(etChildren.text.toString())) {
                                                            if (!TextUtils.isEmpty(etPreg.text.toString())) {

                                                                val resdInfo = MasterModel(
                                                                    0,
                                                                    sharedViewModel.selectedDistrict!!.id,
                                                                    sharedViewModel.selectedDistrict!!.disName,
                                                                    sharedViewModel.selectedProvince!!.id,
                                                                    sharedViewModel.selectedProvince!!.prName,
                                                                    sharedViewModel.selectedTehsil!!.id,
                                                                    sharedViewModel.selectedTehsil!!.tehName,
                                                                    etSerialNo.text.toString()
                                                                        .toInt(),
                                                                    etNameOfPerson.text.toString(),
                                                                    etFatherName.text.toString(),
                                                                    etMotherName.text.toString(),
                                                                    etAddress.text.toString(),
                                                                    etMobileNumber.text.toString(),
                                                                    etDateOfBirth.text.toString(),
                                                                    etAgeInYears.text.toString()
                                                                        .toInt(),
                                                                    selectedGender.toString(),
                                                                    tvMaritalStatus.text.toString(),
                                                                    tvEducation.text.toString(),
                                                                    tvOccupation.text.toString(),
                                                                    etChildren.text.toString(),
                                                                    etPreg.text.toString()
                                                                )
                                                                mViewModel.insertItem(resdInfo)
                                                                Toast.makeText(
                                                                    requireContext(),
                                                                    "Information Registered Successfully!",
                                                                    Toast.LENGTH_LONG
                                                                ).show()

                                                            } else {
                                                                setErrorMessage(
                                                                    writePreg,
                                                                    etPreg,
                                                                    requireContext()
                                                                )
                                                            }

                                                        } else {
                                                            setErrorMessage(
                                                                writeNoOfChildren,
                                                                etChildren,
                                                                requireContext()
                                                            )
                                                        }

                                                    } else {
                                                        setErrorMessage(
                                                            selectOccupation,
                                                            tvOccupation,
                                                            requireContext()
                                                        )
                                                    }

                                                } else {
                                                    setErrorMessage(
                                                        selectEducation,
                                                        tvEducation,
                                                        requireContext()
                                                    )
                                                }

                                            } else {
                                                setErrorMessage(
                                                    writeMaritalStatus,
                                                    tvMaritalStatus,
                                                    requireContext()
                                                )
                                            }

                                        } else {
                                            setErrorMessage(
                                                writeAge,
                                                etAgeInYears,
                                                requireContext()
                                            )
                                        }

                                    } else {
                                        setErrorMessage(
                                            writeDateofBirth,
                                            etDateOfBirth,
                                            requireContext()
                                        )
                                    }

                                } else {
                                    setErrorMessage(writePhoneNum, etMobileNumber, requireContext())
                                }

                            } else {
                                setErrorMessage(writeAddress, etAddress, requireContext())
                            }

                        } else {
                            setErrorMessage(writeMotherName, etMotherName, requireContext())
                        }

                    } else {
                        setErrorMessage(writeFatherName, etFatherName, requireContext())
                    }
                } else {
                    setErrorMessage(writeNameOfPerson, etNameOfPerson, requireContext())
                }

            } else {
                setErrorMessage(writeSerialNo, etSerialNo, requireContext())
            }


//            val resdInfo = MasterModel(0, sharedViewModel.selectedDistrict!!.id, sharedViewModel.selectedDistrict!!.disName, sharedViewModel.selectedProvince!!.id, sharedViewModel.selectedProvince!!.prName, sharedViewModel.selectedTehsil!!.id, sharedViewModel.selectedTehsil!!.tehName,
//                    etSerialNo.text.toString().toInt(), etNameOfPerson.text.toString(), etFatherName.text.toString(), etMotherName.text.toString(), etAddress.text.toString(), etMobileNumber.text.toString(), etDateOfBirth.text.toString(), etAgeInYears.text.toString().toInt(), selectedGender.toString(), tvMaritalStatus.text.toString(), tvEducation.text.toString(), tvOccupation.text.toString(), etChildren.text.toString(), etPreg.text.toString())
//            mViewModel.insertItem(resdInfo)


        }


        checkBtn1.setOnClickListener {
            if (selectedRadioBtn != null) {
                selectedGender = 0
                checkBtn1.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_baseline_check_circle_24
                    )
                )
                selectedRadioBtn!!.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_baseline_radio_button_unchecked_24
                    )
                )
                selectedRadioBtn = checkBtn1
            } else {
                checkBtn1.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_baseline_check_circle_24
                    )
                )
                selectedRadioBtn = checkBtn1
            }

            checkBtn2.setOnClickListener {
                if (selectedRadioBtn != null) {
                    selectedGender = 1
                    checkBtn2.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.ic_baseline_check_circle_24
                        )
                    )
                    selectedRadioBtn!!.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.ic_baseline_radio_button_unchecked_24
                        )
                    )
                    selectedRadioBtn = checkBtn2
                } else {
                    checkBtn2.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.ic_baseline_check_circle_24
                        )
                    )
                    selectedRadioBtn = checkBtn2
                }
            }

        }
    }


}

private fun intialising() {

}


fun setErrorMessage(textView: TextView, editText: EditText, context: Context) {
    textView.visibility = View.VISIBLE
    editText.background = ContextCompat.getDrawable(context, R.drawable.error_drawable)
}


fun checkEdittextWatcher(editText: EditText, textView: TextView) {
    val isValidate = booleanArrayOf(false)
    editText.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun afterTextChanged(s: Editable) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            textView.visibility = View.GONE
            editText.setBackgroundResource(R.drawable.rectangle)
        }
    })
}
