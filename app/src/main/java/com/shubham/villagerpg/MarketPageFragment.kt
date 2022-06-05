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
import androidx.navigation.findNavController
import com.shubham.villagerpg.data.DatabaseCreate
import com.shubham.villagerpg.data.User
import com.shubham.villagerpg.data.UserFunctions
import com.shubham.villagerpg.databinding.MarketPageBinding

class MarketPageFragment : Fragment() {

    private lateinit var binding: MarketPageBinding
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
            R.layout.market_page, container, false
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

        setScreenData()

        setListeners()
        setScreenData()
        val title = "Market"
        binding.head.title.text = title
        return binding.root
    }

    private fun setListeners() {
        binding.buyButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_marketPageFragment_to_buyPageFragment)
        }
        binding.sellButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_marketPageFragment_to_sellPageFragment)
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