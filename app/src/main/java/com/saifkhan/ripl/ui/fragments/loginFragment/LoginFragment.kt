package com.saif.hiringproject.ui.fragments.onBoardingFragment.loginFragment

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.navigation.fragment.findNavController
import com.saifkhan.ripl.BR
import com.saifkhan.ripl.R
import com.saifkhan.ripl.baseclasses.BaseFragment
import com.saifkhan.ripl.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_login.*

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginFragmentViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_login
    override val viewModel: Class<LoginFragmentViewModel>
        get() = LoginFragmentViewModel::class.java
    override val bindingVariable: Int
        get() = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initlising()
        clickListener()
    }

    private fun clickListener() {
        btnContinue.setOnClickListener {
            if (!TextUtils.isEmpty(PhoneNumber.text)) {
                if (!TextUtils.isEmpty(PasswordLogin.text)) {
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                } else {
                    PasswordLogin.error = "please write password"
                }

            } else {
                PhoneNumber.error = "please write login and press Conitnue"
            }
        }

    }

    private fun initlising() {

    }
}