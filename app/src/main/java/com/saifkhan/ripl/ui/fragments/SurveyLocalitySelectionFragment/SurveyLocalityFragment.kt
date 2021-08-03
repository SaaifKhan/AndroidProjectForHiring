package com.saifkhan.ripl.ui.fragments.SurveyLocalitySelectionFragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.saifkhan.ripl.BR
import com.saifkhan.ripl.R
import com.saifkhan.ripl.baseclasses.BaseFragment
import com.saifkhan.ripl.databinding.FragmentSurveyLocationFramentBinding
import com.saifkhan.ripl.utils.ConstantUtilList
import com.saif.hiringproject.data.models.DistrictModel
import com.saif.hiringproject.data.models.ProvinceModel
import com.saif.hiringproject.data.models.TeshsilModel
import com.saif.hiringproject.ui.fragments.SurveylocalityselectionFragment.adapter.DistrictAdapter
import com.saif.hiringproject.ui.fragments.SurveylocalityselectionFragment.adapter.ProvinceAdapter
import com.saif.hiringproject.ui.fragments.SurveylocalityselectionFragment.adapter.TehsilsAdapter
import com.saif.hiringproject.ui.fragments.onBoardingFragment.loginFragment.SurveyLocalityFragmentViewModel
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
            findNavController().navigate(R.id.action_surveyLocationFragment_to_residentInformationFragment)

        }
    }

    private fun intialising() {
        adapterProvince = ProvinceAdapter(
            ConstantUtilList.getProvince(),
            object : ProvinceAdapter.ClickItemListener {
                override fun onClicked(position: Int) {
                    val model: ProvinceModel = ConstantUtilList.getProvince()[position]
                    sharedViewModel.selectedProvince = model
                    tvProvince.text = model.prName
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
                    editTextDisctrict.text = modelDistrict.disName.toString()
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

                    editTextTehsils.text = modelTehsil.tehName.toString()
                    expandable_layout_disctrict.setExpanded(false, true)
                }

            })
        recyclerViewTehsils.adapter = tehsilAdapter
        tehsilAdapter.notifyDataSetChanged()

    }
}