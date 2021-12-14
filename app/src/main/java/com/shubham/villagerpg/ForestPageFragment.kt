package com.shubham.villagerpg

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.shubham.villagerpg.data.*
import com.shubham.villagerpg.databinding.ForestPageBinding

class ForestPageFragment : Fragment() {

    private lateinit var binding: ForestPageBinding
    private lateinit var inventoryDatabase: InventoryDatabaseDao
    private lateinit var data: SharedPreferences
    private var user = User()

    private fun setScreenData() {
        binding.head.name.text = user.name
        binding.head.money.text = user.money.toString()
        binding.head.gold.text = user.gold.toString()
        binding.head.xp.text = user.xp.toString()
        binding.head.stamina.text = user.stamina.toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.forest_page, container, false
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
        binding.findingLayout.visibility = View.GONE
        setScreenData()
        setListeners()
        val title = "Forest"
        binding.head.title.text = title
        return binding.root
    }

    private fun setListeners() {
        binding.exploreButton.setOnClickListener {

            val itemList = arrayOf(
                inventoryDatabase.get(0),
                inventoryDatabase.get(1),
                inventoryDatabase.get(20000),
                inventoryDatabase.get(20001),
                inventoryDatabase.get(30000),
                inventoryDatabase.get(30001),
                inventoryDatabase.get(40000),
                inventoryDatabase.get(40001),
                inventoryDatabase.get(40002),
                inventoryDatabase.get(40003)
            )

            val itemExplored = itemList[(itemList.indices).random()]
            val numberOfItem = (0..3).random()
            binding.findingLayout.visibility = View.VISIBLE
            if (itemExplored != null) {
                if (numberOfItem != 0) {
                    val text = numberOfItem.toString() + itemExplored.name
                    binding.finding.text = text
                    itemExplored.quantity += numberOfItem
                    inventoryDatabase.update(itemExplored)
                    user.xp += itemExplored.xp
                } else {
                    val nothing = "nothing"
                    binding.finding.text = nothing
                }
            }
            setScreenData()
        }

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