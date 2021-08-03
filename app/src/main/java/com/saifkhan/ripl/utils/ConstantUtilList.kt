package com.saifkhan.ripl.utils

import com.saif.hiringproject.data.models.*

class ConstantUtilList {
    companion object {
        fun getProvince(): ArrayList<ProvinceModel> {
            val list = ArrayList<ProvinceModel>()
            list.add(ProvinceModel(0, "Sindh"))
            list.add(ProvinceModel(1, "Punjab"))
            list.add(ProvinceModel(2, "KPK"))
            list.add(ProvinceModel(3, "Balochistan"))
            return list
        }


        fun getDistrict(): ArrayList<DistrictModel> {
            val list = ArrayList<DistrictModel>()
            list.add(DistrictModel(0, "karachi"))
            list.add(DistrictModel(1, "Lahore"))
            return list
        }

        fun getTehsils(): ArrayList<TeshsilModel> {
            val list = ArrayList<TeshsilModel>()
            list.add(TeshsilModel(0, "hydery"))
            list.add(TeshsilModel(1, "sakhi hassan"))
            list.add(TeshsilModel(3, "buffer zone"))
            list.add(TeshsilModel(4, "ayesha manzil"))
            list.add(TeshsilModel(5, "saddar"))
            list.add(TeshsilModel(6, "paposh nagar"))
            list.add(TeshsilModel(7, "nazimabad"))
            return list
        }

        fun getMaritalStatus(): ArrayList<MartialStatusModel> {
            val list = ArrayList<MartialStatusModel>()
            list.add(MartialStatusModel(0, "Unmarried"))
            list.add(MartialStatusModel(1, "Married"))
            list.add(MartialStatusModel(3, "Divorce"))
            list.add(MartialStatusModel(4, "Widow"))
            return list
        }

        fun geteducation(): ArrayList<EducationModel> {
            val list = ArrayList<EducationModel>()
            list.add(EducationModel(0, "No Education"))
            list.add(EducationModel(1, "Primary School"))
            list.add(EducationModel(3, "Secondary School"))
            list.add(EducationModel(4, "Matric/O Levels"))
            list.add(EducationModel(5, "Intermediate/A-Levels"))
            list.add(EducationModel(6, "Unemployed"))
            list.add(EducationModel(7, "Retired"))
            return list
        }

        fun getOccupation(): ArrayList<OccupationModel> {
            val list = ArrayList<OccupationModel>()
            list.add(OccupationModel(0, "Student"))
            list.add(OccupationModel(1, "Housewife"))
            list.add(OccupationModel(3, "Trader"))
            list.add(OccupationModel(4, "Business"))
            list.add(OccupationModel(5, "NGO employee"))
            list.add(OccupationModel(6, "Unemployed"))
            list.add(OccupationModel(7, "Retired"))
            return list
        }
    }
}