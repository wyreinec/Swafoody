package com.cl.swafoody

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.cl.swafoody.databinding.FragmentItemViewAllBinding
import com.cl.swafoody.recyclerView.ArrayOfSavedFood


/**
 * A fragment representing a list of Items.
 */
class ItemViewAllFoodFragment : Fragment() {

    private var _binding: FragmentItemViewAllBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemViewAllBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupRecyclerView()


        //Navigation.findNavController(root).navigate(com.marqumil.mvh_healthcare.R.id.itemViewAllFoodFragment)
        return root
    }

    // execute recyclerView Saved Recipe
    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            // Create a grid layout with two columns
            var layoutManager = GridLayoutManager(context, 2)

            val recyclerView = binding.recyclerView
            recyclerView.layoutManager = layoutManager

            val arraOfsavedFood = ArrayOfSavedFood() // instansiasi kelas arrayOfSavedFood

            adapter = MyItemViewAllFoodRecyclerViewAdapter(arraOfsavedFood.createSavedFoods()) { food, position ->
                Toast.makeText(
                    context,
                    "Clicked on actor: ${food.name}",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // this event will enable the back
    // function to the button on press
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home-> {

                return true
            }
        }
        return super.onContextItemSelected(item)
    }
}