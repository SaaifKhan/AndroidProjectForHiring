package com.saif.hiringproject.ui.fragments.onBoardingFragment.loginFragment

import com.saifkhan.ripl.baseclasses.BaseViewModel
import com.saifkhan.ripl.data.remote.reporitory.MainRepository
import com.saifkhan.ripl.utils.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : BaseViewModel()