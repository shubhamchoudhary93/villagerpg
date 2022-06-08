package com.shubham.villagerpg

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.shubham.villagerpg.data.*
import com.shubham.villagerpg.databinding.ForestPageBinding

class ForestPageFragment : Fragment() {

    private lateinit var binding: ForestPageBinding
    private lateinit var inventoryDatabase: InventoryDatabaseDao
    private lateinit var data: SharedPreferences
    lateinit var mainHandler: Handler
    private var user = User()
    private var first = true

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

    private fun setScreenData() {
        user = UserFunctions.calculateLevel(user)
        binding.head.name.text = user.name
        binding.head.money.text = user.money.toString()
        binding.head.gold.text = user.gold.toString()
        binding.head.level.text = user.level.toString()
        binding.head.food.text = user.food.toString()
        val xpText = user.xp.toString() + "/" + user.nextXp.toString()
        binding.head.xp.text = xpText
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
                user.lastOnlineStamina = System.currentTimeMillis()
                UserFunctions.saveUser(user, data)
                DatabaseCreate.createFirst(requireContext())
            }
        }
        mainHandler = Handler(Looper.getMainLooper())

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
            if (user.food >= 1) {
                val itemList = arrayOf(
                    inventoryDatabase.getName("Wood"),
                    inventoryDatabase.getName("Stone"),
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
                } else {
                    val nothing = "nothing"
                    binding.finding.text = nothing
                }
                setScreenData()
            } else {
                Toast.makeText(context, "No more food", Toast.LENGTH_SHORT).show()
                binding.findingLayout.visibility = View.GONE
            }
        }

    }

    override fun onPause() {
        super.onPause()
        user.lastOnline = System.currentTimeMillis()
        user.lastOnlineStamina = System.currentTimeMillis()
        UserFunctions.saveUser(user, data)
        mainHandler.removeCallbacks(updateStamina)
    }

    override fun onResume() {
        super.onResume()
        user = UserFunctions.fetchUser(data)
        val currentTime = System.currentTimeMillis()
        val staminaAdd: Int = ((currentTime - user.lastOnlineStamina) / 60000).toInt()
        val staminaNew = user.food + staminaAdd
        user.food = staminaNew
        mainHandler.post(updateStamina)
    }

}