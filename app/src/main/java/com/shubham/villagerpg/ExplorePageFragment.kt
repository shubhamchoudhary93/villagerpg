package com.shubham.villagerpg

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shubham.villagerpg.data.*
import com.shubham.villagerpg.databinding.ExplorePageBinding

class ExplorePageFragment : Fragment() {

    private lateinit var binding: ExplorePageBinding
    private lateinit var data: SharedPreferences
    lateinit var mainHandler: Handler
    private var user = User()
    private lateinit var inventoryDatabase: InventoryDatabaseDao
    private var foodList: MutableList<Inventory> = mutableListOf()
    private var first = true

    private val updateScreenTask = object : Runnable {
        override fun run() {
            user.money++
            setScreenData()
            mainHandler.postDelayed(this, 1000)
        }
    }

    private val updateStamina = object : Runnable {
        override fun run() {
            if(!first) {
                user.food++
            }
            first = false
            binding.head.food.text = user.food.toString()
            mainHandler.postDelayed(this, 60000)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.explore_page, container, false
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

        foodList = inventoryDatabase.getAvailableItem("food", user.level)

        val names: MutableList<String> = mutableListOf()
        var text: String
        for (j in foodList.indices) {
            text = foodList[j].name + " (" + foodList[j].quantity + ")"
            names.add(text)
        }

        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(
                this.requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                names
            )
        binding.foodDropdown.adapter = adapter

        setScreenData()
        setListeners()
        val title = "Explore"
        binding.head.title.text = title
        return binding.root
    }


    private fun setScreenData() {
        user = UserFunctions.calculateLevel(user)
        binding.head.name.text = user.name
        binding.head.money.text = user.money.toString()
        binding.head.gold.text = user.gold.toString()
        binding.head.level.text = user.level.toString()
        binding.head.food.text = user.food.toString()
    }

    private fun setListeners() {
        binding.forestButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_explorePageFragment_to_forestPageFragment)
        }
        binding.barrenButton.setOnClickListener {
//            view?.findNavController()
//                ?.navigate(R.id.action_marketPageFragment_to_sellPageFragment)
        }
        binding.pondButton.setOnClickListener {
//            view?.findNavController()
//                ?.navigate(R.id.action_marketPageFragment_to_sellPageFragment)
        }

        binding.foodDropdown.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parentView: AdapterView<*>?,
                    selectedItemView: View?,
                    position: Int,
                    id: Long
                ) {
                    val foodSelected = foodList[position]
                    val count = binding.foodCount.text.toString().toInt()
                    user.food += (count * foodSelected.stamina.toLong())
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    binding.convertButton.isEnabled = false
                }
            }
    }

    override fun onPause() {
        super.onPause()
        user.lastOnline = System.currentTimeMillis()
        UserFunctions.saveUser(user, data)
        mainHandler.removeCallbacks(updateStamina)
        mainHandler.removeCallbacks(updateScreenTask)
    }

    override fun onResume() {
        super.onResume()
        user = UserFunctions.fetchUser(data)
        val currentTime = System.currentTimeMillis()
        val staminaAdd: Int = ((currentTime - user.lastOnline) / 60000).toInt()
        val staminaNew = user.food + staminaAdd
        user.food = staminaNew
        mainHandler.post(updateStamina)
        mainHandler.post(updateScreenTask)
    }

}