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
        user = UserFunctions.calculateLevel(user)
        binding.head.name.text = user.name
        binding.head.money.text = user.money.toString()
        binding.head.gold.text = user.gold.toString()
        binding.head.level.text = user.level.toString()
        binding.head.food.text = user.food.toString()
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
            if (user.food > 0) {
                val itemList = arrayOf(
                    inventoryDatabase.getName("Wood"),
                    inventoryDatabase.getName("Iron"),
                    null,
                    null,
                    null,
                    null,
                    null,
                    null
                )

                val itemExplored = itemList[(itemList.indices).random()]
                val numberOfItem = (0..2).random()
                user.food--
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
            } else binding.findingLayout.visibility = View.GONE
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