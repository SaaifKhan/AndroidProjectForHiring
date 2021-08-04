package com.saifkhan.ripl.ui.fragments.homeFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.saif.hiringproject.ui.fragments.onBoardingFragment.loginFragment.HomeViewModel
import com.saif.hiringproject.ui.fragments.onBoardingFragment.loginFragment.LoginFragmentViewModel
import com.saifkhan.ripl.BR
import com.saifkhan.ripl.R
import com.saifkhan.ripl.baseclasses.BaseFragment
import com.saifkhan.ripl.databinding.FragmentHomeBinding
import com.saifkhan.ripl.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {





    override val layoutId: Int
        get() = R.layout.fragment_home
    override val viewModel: Class<HomeViewModel>
        get() = HomeViewModel::class.java
    override val bindingVariable: Int
        get() = BR.viewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intialising()
        clickListner()
    }

    private fun clickListner() {
        btnReqeustAsAddResident.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_surveyLocationFragment)

        }
        btnViewResidents.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_residentListFragment)

        }
    }

    private fun intialising() {

    }
}