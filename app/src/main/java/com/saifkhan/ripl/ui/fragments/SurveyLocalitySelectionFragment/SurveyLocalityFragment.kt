package com.saifkhan.ripl.ui.fragments.SurveyLocalitySelectionFragment

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.saif.hiringproject.data.models.DistrictModel
import com.saif.hiringproject.data.models.ProvinceModel
import com.saif.hiringproject.data.models.TeshsilModel
import com.saif.hiringproject.ui.fragments.SurveylocalityselectionFragment.adapter.DistrictAdapter
import com.saif.hiringproject.ui.fragments.SurveylocalityselectionFragment.adapter.ProvinceAdapter
import com.saif.hiringproject.ui.fragments.SurveylocalityselectionFragment.adapter.TehsilsAdapter
import com.saif.hiringproject.ui.fragments.onBoardingFragment.loginFragment.SurveyLocalityFragmentViewModel
import com.saifkhan.ripl.BR
import com.saifkhan.ripl.R
import com.saifkhan.ripl.baseclasses.BaseFragment
import com.saifkhan.ripl.databinding.FragmentSurveyLocationFramentBinding
import com.saifkhan.ripl.utils.ConstantUtilList
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_survey_location_frament.*

@AndroidEntryPoint
class SurveyLocationFragment :
    BaseFragment<FragmentSurveyLocationFramentBinding, SurveyLocalityFragmentViewModel>() {


    override val layoutId: Int
        get() = R.layout.fragment_survey_location_frament
    override val viewModel: Class<SurveyLocalityFragmentViewModel>
        get() = SurveyLocalityFragmentViewModel::class.java
    override val bindingVariable: Int
        get() = BR.viewModel


    lateinit var adapterProvince: ProvinceAdapter
    lateinit var districtAdapter: DistrictAdapter
    lateinit var tehsilAdapter: TehsilsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intialising()
        clickListener()
    }

    private fun clickListener() {
        tvProvince.setOnClickListener {
            expandable_layout.setExpanded(!expandable_layout.isExpanded, true)

        }
        editTextDisctrict.setOnClickListener {
            expandable_layout_disctrict.setExpanded(!expandable_layout_disctrict.isExpanded, true)

        }

        editTextTehsils.setOnClickListener {
            expandable_layout_tehsils.setExpanded(!expandable_layout_tehsils.isExpanded, true)
        }

        btnContinue.setOnClickListener {
            if (!TextUtils.isEmpty(tvProvince.text.toString())) {
                if (!TextUtils.isEmpty(editTextDisctrict.text.toString())) {
                    if (!TextUtils.isEmpty(editTextTehsils.text.toString())) {
                        Toast.makeText(requireContext(), "Successfully!", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_surveyLocationFragment_to_residentInformationFragment)
                    } else {
                        setErrorMessage(selectTehsil, editTextTehsils, requireContext())
                    }

                } else {
                    setErrorMessage(selectDistrict, editTextDisctrict, requireContext())
                }

            } else {
                setErrorMessage(selectProvince, tvProvince, requireContext())
            }

        }
    }

    private fun intialising() {
        checkEdittextWatcher(tvProvince, selectProvince)
        checkEdittextWatcher(editTextDisctrict, selectDistrict)
        checkEdittextWatcher(editTextTehsils, selectTehsil)



        adapterProvince = ProvinceAdapter(
            ConstantUtilList.getProvince(),
            object : ProvinceAdapter.ClickItemListener {
                override fun onClicked(position: Int) {
                    val model: ProvinceModel = ConstantUtilList.getProvince()[position]
                    sharedViewModel.selectedProvince = model
                    tvProvince.setText(model.prName.toString())
                    expandable_layout.setExpanded(false, true)
                }

            })
        recyclerViewProvince.adapter = adapterProvince
        adapterProvince.notifyDataSetChanged()


        districtAdapter = DistrictAdapter(ConstantUtilList.getDistrict(),
            object : DistrictAdapter.ClickItemListener {
                override fun onClicked(position: Int) {
                    val modelDistrict: DistrictModel = ConstantUtilList.getDistrict()[position]
                    sharedViewModel.selectedDistrict = modelDistrict
                    editTextDisctrict.setText(modelDistrict.disName.toString())
                    expandable_layout_disctrict.setExpanded(false, true)

                }

            })
        recyclerViewDistrict.adapter = districtAdapter
        districtAdapter.notifyDataSetChanged()

        tehsilAdapter = TehsilsAdapter(ConstantUtilList.getTehsils(),
            object : TehsilsAdapter.ClickItemListener {
                override fun onClicked(position: Int) {
                    val modelTehsil: TeshsilModel = ConstantUtilList.getTehsils()[position]
                    sharedViewModel.selectedTehsil = modelTehsil
                    editTextTehsils.setText(modelTehsil.tehName.toString())
                    expandable_layout_disctrict.setExpanded(false, true)
                }

            })
        recyclerViewTehsils.adapter = tehsilAdapter
        tehsilAdapter.notifyDataSetChanged()

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
}


