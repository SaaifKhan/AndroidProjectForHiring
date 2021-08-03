package com.saif.hiringproject.ui.fragments.onBoardingFragment.loginFragment

import com.saifkhan.ripl.MainApplication
import com.saifkhan.ripl.baseclasses.BaseViewModel
import com.saifkhan.ripl.data.local.db.AppDatabase
import com.saifkhan.ripl.data.remote.reporitory.MainRepository
import com.saifkhan.ripl.utils.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SurveyLocalityFragmentViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : BaseViewModel(){

    val allItems = AppDatabase.getDatabase(MainApplication.context).appDao().getAllItem()

}