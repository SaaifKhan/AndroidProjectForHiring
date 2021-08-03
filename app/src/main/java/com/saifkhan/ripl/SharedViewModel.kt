package com.saifkhan.ripl

import androidx.lifecycle.MutableLiveData
import com.saif.hiringproject.data.models.DistrictModel
import com.saif.hiringproject.data.models.ProvinceModel
import com.saif.hiringproject.data.models.TeshsilModel
import com.saifkhan.ripl.baseclasses.BaseViewModel


/**
 * Shared View Model class for sharing data between fragments
 */
class SharedViewModel : BaseViewModel() {

    val clickOnContinueBtn : MutableLiveData<Boolean> ?= null
    var selectedDistrict:DistrictModel ?= null
    var selectedProvince:ProvinceModel ?= null
    var selectedTehsil:TeshsilModel ?= null

}