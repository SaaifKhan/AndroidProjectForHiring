package com.saifkhan.ripl.ui.fragments.listWithFilterScreen

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.saif.hiringproject.ui.fragments.SurveylocalityselectionFragment.adapter.ResidentListAdapter
import com.saif.hiringproject.ui.fragments.onBoardingFragment.loginFragment.ResidentInformationViewModel
import com.saif.hiringproject.ui.fragments.onBoardingFragment.loginFragment.ResidentListViewModel
import com.saifkhan.ripl.BR
import com.saifkhan.ripl.R
import com.saifkhan.ripl.baseclasses.BaseFragment
import com.saifkhan.ripl.data.models.MasterModel
import com.saifkhan.ripl.databinding.FragmentListWithFilterScreenBinding
import com.saifkhan.ripl.databinding.FragmentResidentInformationBinding
import com.saifkhan.ripl.utils.DialogClass
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.dialog_filter.*
import kotlinx.android.synthetic.main.fragment_list_with_filter_screen.*

@AndroidEntryPoint
class ResidentListFragment :
    BaseFragment<FragmentListWithFilterScreenBinding, ResidentListViewModel>() {


    override val layoutId: Int
        get() = R.layout.fragment_list_with_filter_screen
    override val viewModel: Class<ResidentListViewModel>
        get() = ResidentListViewModel::class.java
    override val bindingVariable: Int
        get() = BR.viewModel

    val masterList = ArrayList<MasterModel>()
    val refList = ArrayList<MasterModel>()

    lateinit var filterDialog: Dialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intialising()
        mViewModel.allItems.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            Log.d("Item ", "${it.size}")
            masterList.clear()
            refList.clear()
            masterList.addAll(it)
            refList.addAll(it)
            totalCounts(it)
            recyclerViewListOfResident.adapter?.notifyDataSetChanged()

        })
        clickListener()
    }

    private fun clickListener() {
        imgBackRequest.setOnClickListener {
            findNavController().popBackStack()
        }
        imgFilter.setOnClickListener {
            filterDialog = DialogClass.filterListDialog(requireContext())
            filterDialog.tvMaleDialog.setOnClickListener {
                refList.clear()
                masterList.forEachIndexed { index, masterModel ->
                    if (masterModel.Gender == "0") {
                        refList.add(masterModel)
                    }
                }
                filterDialog.dismiss()
                recyclerViewListOfResident.adapter?.notifyDataSetChanged()
            }

            filterDialog.tvFemale.setOnClickListener {
                refList.clear()

                masterList.forEachIndexed { index, masterModel ->
                    if (masterModel.Gender == "1") {
                        refList.add(masterModel)
                    }
                }
                filterDialog.dismiss()
                recyclerViewListOfResident.adapter?.notifyDataSetChanged()


            }

            filterDialog.tvBelow18.setOnClickListener {
                refList.clear()

                masterList.forEachIndexed { index, masterModel ->
                    if (masterModel.Age!! < 18) {
                        refList.add(masterModel)
                    }
                }
                filterDialog.dismiss()
                recyclerViewListOfResident.adapter?.notifyDataSetChanged()


            }

            filterDialog.tvAbove18.setOnClickListener {
                refList.clear()
                masterList.forEachIndexed { index, masterModel ->
                    if (masterModel.Age!! > 18) {
                        refList.add(masterModel)
                    }
                }
                filterDialog.dismiss()
                recyclerViewListOfResident.adapter?.notifyDataSetChanged()


            }
            filterDialog.show()

        }

    }

    private fun intialising() {
        recyclerViewListOfResident.adapter =
            ResidentListAdapter(refList, object : ResidentListAdapter.ClickItemListener {
                override fun onClicked(position: Int) {
                }
            })
    }

    private fun totalCounts(list: List<MasterModel>) {
        var totalMaleCount = 0
        var totalFemaleCount = 0
        var totalKhiCount = 0
        var totalLhrCount = 0
        var totalMaritalStatusForAbove14 = 0
        list.forEachIndexed { index, masterModel ->
            if (masterModel.Gender == "0") {
                //count for male
                totalMaleCount++


            }
            if (masterModel.Gender == "1") {
                //count for female
                totalFemaleCount++


            }
            if (masterModel.disId == 0) {
                //count for khi
                totalKhiCount++


            }
            if (masterModel.disId == 1) {
                //count for lhr
                totalLhrCount++


            }
            if (masterModel.Age!! > 14 && masterModel.MartialStatus.equals("Married")) {
                totalMaritalStatusForAbove14++
            }
        }
        tvTotalMaleCount.text = totalMaleCount.toString()
        tvTotalFemaleCount.text = totalFemaleCount.toString()
        tvTotalCountProvince.text = "$totalKhiCount,$totalLhrCount"
        tvCountMaritalStatus.text = totalMaritalStatusForAbove14.toString()

    }
}