package com.saif.hiringproject.ui.fragments.onBoardingFragment.loginFragment

import android.os.Bundle
import com.saifkhan.ripl.BR
import com.saifkhan.ripl.R
import com.saifkhan.ripl.baseclasses.BaseFragment
import com.saifkhan.ripl.databinding.FragmentLoginBinding

class LoginFragment: BaseFragment<FragmentLoginBinding, LoginFragmentViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_login
    override val viewModel: Class<LoginFragmentViewModel>
        get() = LoginFragmentViewModel::class.java
    override val bindingVariable: Int
        get() = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}