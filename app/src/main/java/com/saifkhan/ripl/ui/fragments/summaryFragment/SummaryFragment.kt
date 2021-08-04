package com.saifkhan.ripl.ui.fragments.summaryFragment

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.saif.hiringproject.data.models.EducationModel
import com.saif.hiringproject.data.models.MartialStatusModel
import com.saif.hiringproject.data.models.OccupationModel
import com.saif.hiringproject.ui.fragments.SurveylocalityselectionFragment.adapter.EducationAdapter
import com.saif.hiringproject.ui.fragments.SurveylocalityselectionFragment.adapter.MaritalStatusAdapter
import com.saif.hiringproject.ui.fragments.SurveylocalityselectionFragment.adapter.OccupationAdapter
import com.saif.hiringproject.ui.fragments.onBoardingFragment.loginFragment.ResidentInformationViewModel
import com.saif.hiringproject.ui.fragments.onBoardingFragment.loginFragment.SummaryFragmentViewModel
import com.saifkhan.ripl.BR
import com.saifkhan.ripl.R
import com.saifkhan.ripl.baseclasses.BaseFragment
import com.saifkhan.ripl.data.models.MasterModel
import com.saifkhan.ripl.databinding.FragmentResidentInformationBinding
import com.saifkhan.ripl.databinding.FragmentSummaryBinding
import com.saifkhan.ripl.utils.ConstantUtilList
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_resident_information.*
import java.util.*


@AndroidEntryPoint
class SummaryFragment : BaseFragment<FragmentSummaryBinding, SummaryFragmentViewModel>() {


    override val layoutId: Int
        get() = R.layout.fragment_summary
    override val viewModel: Class<SummaryFragmentViewModel>
        get() = SummaryFragmentViewModel::class.java
    override val bindingVariable: Int
        get() = BR.viewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intialising()
        clickListener()
    }

    private fun clickListener() {


    }

    private fun intialising() {

    }
}
