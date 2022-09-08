package com.iyilmaz.signupfragmentstutorial.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.iyilmaz.signupfragmentstutorial.R
import com.iyilmaz.signupfragmentstutorial.databinding.FragmentCarListBinding
import com.iyilmaz.signupfragmentstutorial.entity.Person

class CarListFragment : Fragment() {
    private lateinit var binding: FragmentCarListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCarListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cars = resources.getStringArray(R.array.cars)
        val arrayAdapterCar: ArrayAdapter<String> = ArrayAdapter(
            requireContext(), android.R.layout.simple_list_item_1, cars
        )
        binding.carListView.adapter = arrayAdapterCar
        binding.carListView.setOnItemClickListener { _, _, _, _ ->
            val direction2 =
                CarListFragmentDirections.actionCarListFragmentToSignUpFragment(binding.carListView.selectedItem.toString())
            findNavController().navigate(direction2)
        }
    }
}