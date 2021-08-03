package com.saifkhan.ripl.ui.activity

import com.saifkhan.ripl.baseclasses.BaseViewModel
import com.saifkhan.ripl.data.remote.reporitory.MainRepository
import com.saifkhan.ripl.utils.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : BaseViewModel() {


}
