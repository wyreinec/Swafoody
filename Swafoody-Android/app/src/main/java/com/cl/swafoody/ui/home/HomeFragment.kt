package com.cl.swafoody.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.cl.swafoody.databinding.FragmentHomeBinding
import com.cl.swafoody.R
import com.cl.swafoody.recyclerView.ArrayOfSavedFood
import com.cl.swafoody.recyclerView.CustomAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val btnSwafoody: Button = binding.btnAddIngredients
        val txtViewAll: TextView = binding.txtViewAll

        homeViewModel.text.observe(viewLifecycleOwner) {
            //textView.text = it
            setupRecyclerView()
            btnSwafoody.setOnClickListener {
                //textView.text = "wkwk"
            }

        }

        txtViewAll.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.itemViewAllFoodFragment)
        }



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // execute recyclerView Saved Recipe
    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            val arraOfsavedFood = ArrayOfSavedFood() // instansiasi kelas arrayOfSavedFood

            adapter = CustomAdapter(arraOfsavedFood.createSavedFoods()) { food, position ->
                Toast.makeText(
                    context,
                    "Clicked on actor: ${food.name}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }


}