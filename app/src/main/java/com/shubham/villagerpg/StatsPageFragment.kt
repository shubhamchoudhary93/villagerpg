package com.shubham.villagerpg

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.shubham.villagerpg.data.*
import com.shubham.villagerpg.databinding.StatsPageBinding

class StatsPageFragment : Fragment() {

    private lateinit var binding: StatsPageBinding
    private lateinit var inventoryDatabase: InventoryDatabaseDao
    private lateinit var data: SharedPreferences
    private var user = User()

    private fun setScreenData() {
        user = UserFunctions.calculateLevel(user)
        binding.head.name.text = user.name
        binding.head.money.text = user.money.toString()
        binding.head.gold.text = user.gold.toString()
        binding.head.level.text = user.level.toString()
        binding.head.food.text = user.food.toString()

        var text = "User Data\n"

        text = text + "\nname : " + user.name
        text = text + "\nxp : " + user.xp
        text = text + "\nlevel : " + user.level
        text = text + "\nnextXp : " + user.nextXp
        text = text + "\nmoney : " + user.money
        text = text + "\nfood : " + user.food
        text = text + "\ngold : " + user.gold
        text = text + "\nlastOnline : " + user.lastOnline
        text = text + "\nfarmStatus : " + user.farm
        text = text + "\ncampStatus : " + user.camp
        text = text + "\nfactoryStatus : " + user.factory
        text = text + "\nkitchenStatus : " + user.kitchen

        binding.userData.text = text
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.stats_page, container, false
        )

        data = requireActivity().getSharedPreferences("VillageRPGData", Context.MODE_PRIVATE)
        user = if (data.contains("User")) {
            UserFunctions.fetchUser(data)
        } else {
            user.also {
                user.lastOnline = System.currentTimeMillis()
                UserFunctions.saveUser(user, data)
                DatabaseCreate.createFirst(requireContext())
            }
        }

        inventoryDatabase = InventoryDatabase.getInstance(requireContext()).inventoryDatabaseDao
        val list = inventoryDatabase.getAvailable()

        binding.inventoryData.text = list.toString()
        setScreenData()
        val title = "Stats"
        binding.head.title.text = title
        return binding.root
    }

    override fun onPause() {
        super.onPause()
        user.lastOnline = System.currentTimeMillis()
        UserFunctions.saveUser(user, data)
    }

    override fun onResume() {
        super.onResume()
        user = UserFunctions.fetchUser(data)
    }

}