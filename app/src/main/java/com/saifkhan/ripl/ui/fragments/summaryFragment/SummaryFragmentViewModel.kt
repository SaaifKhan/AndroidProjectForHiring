package com.saif.hiringproject.ui.fragments.onBoardingFragment.loginFragment

import com.saifkhan.ripl.MainApplication
import com.saifkhan.ripl.baseclasses.BaseViewModel
import com.saifkhan.ripl.data.local.db.AppDatabase.Companion.getDatabase
import com.saifkhan.ripl.data.models.MasterModel
import com.saifkhan.ripl.data.remote.reporitory.MainRepository
import com.saifkhan.ripl.utils.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SummaryFragmentViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : BaseViewModel(){

    val allItems = getDatabase(MainApplication.context).appDao().getAllItem()




    fun insertItem(model:MasterModel){
        GlobalScope.launch {
            try {
                getDatabase(MainApplication.context).appDao().insertEntry(model)

            }catch (e:Exception){

            }
        }
    }
}