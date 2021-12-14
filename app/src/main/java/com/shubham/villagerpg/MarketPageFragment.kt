package com.shubham.villagerpg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shubham.villagerpg.databinding.MarketPageBinding

class MarketPageFragment : Fragment() {

    private lateinit var binding: MarketPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.market_page, container, false
        )
        setListeners()
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

}