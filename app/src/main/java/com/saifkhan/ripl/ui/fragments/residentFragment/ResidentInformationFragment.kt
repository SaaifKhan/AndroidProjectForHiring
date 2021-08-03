package com.saifkhan.ripl.ui.fragments.residentFragment

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
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
class ResidentInformationFragment : BaseFragment<FragmentResidentInformationBinding, ResidentInformationViewModel>() {


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
    val selectedGender: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.allItems.observe(this, androidx.lifecycle.Observer {
            Log.d("Item ","${it.size}")
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intialising()
        clickListener()
    }

    @SuppressLint("SimpleDateFormat")
    private fun clickListener() {


        maritalStatusAdapter = MaritalStatusAdapter(ConstantUtilList.getMaritalStatus(), object : MaritalStatusAdapter.ClickItemListener {
            override fun onClicked(position: Int) {
                val model: MartialStatusModel = ConstantUtilList.getMaritalStatus()[position]
                tvMaritalStatus.text = model.maritalStatusName
                expandable_layout_marital_status.setExpanded(false, true)
            }

        })
        recyclerViewMaritalStatus.adapter = maritalStatusAdapter
        maritalStatusAdapter.notifyDataSetChanged()
        tvMaritalStatus.setOnClickListener {
            expandable_layout_marital_status.setExpanded(!expandable_layout_marital_status.isExpanded, true)
        }

        occupationAdapter = OccupationAdapter(ConstantUtilList.getOccupation(), object : OccupationAdapter.ClickItemListener {
            override fun onClicked(position: Int) {
                val model: OccupationModel = ConstantUtilList.getOccupation()[position]
                tvOccupation.text = model.occName.toString()
                expandable_layout_occupation.setExpanded(false, true)
            }

        })
        recyclerViewOccupation.adapter = occupationAdapter
        occupationAdapter.notifyDataSetChanged()
        tvOccupation.setOnClickListener {
            expandable_layout_occupation.setExpanded(!expandable_layout_occupation.isExpanded, true)
        }

        educationAdapter = EducationAdapter(ConstantUtilList.geteducation(), object : EducationAdapter.ClickItemListener {
            override fun onClicked(position: Int) {
                val model: EducationModel = ConstantUtilList.geteducation()[position]
                tvEducation.text = model.educationName.toString()
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


            DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener { _, year, month, day ->
                etDateOfBirth.setText("$year-${month + 1}-$day")
            }, startYear, startMonth, startDay).show()
        }


        btnSubmit.setOnClickListener {
            if (!TextUtils.isEmpty(etSerialNo.text.toString())) {

            }
            val resdInfo = MasterModel(0, sharedViewModel.selectedDistrict!!.id, sharedViewModel.selectedDistrict!!.disName, sharedViewModel.selectedProvince!!.id, sharedViewModel.selectedProvince!!.prName, sharedViewModel.selectedTehsil!!.id, sharedViewModel.selectedTehsil!!.tehName,
                    etSerialNo.text.toString().toInt(), etNameOfPerson.text.toString(), etFatherName.text.toString(), etMotherName.text.toString(), etAddress.text.toString(), etMobileNumber.text.toString(), etDateOfBirth.text.toString(), etAgeInYears.text.toString(), "0", tvMaritalStatus.text.toString(), tvEducation.text.toString(), tvOccupation.text.toString(), etChildren.text.toString(), etPreg.text.toString())
            mViewModel.insertItem(resdInfo)


        }

    }

    private fun intialising() {

    }
}