package com.cl.swafoody.recyclerView
import com.cl.swafoody.R

class ArrayOfSavedFood {
    // fun arrayList of Saaved Recipe
    fun createSavedFoods(): ArrayList<item> {
        return arrayListOf<item>(
            item(
                "Nasgor Telor",
                R.drawable.food1
            ),
            item(
                "Rujak Buah",
                R.drawable.food2
            ),
            item(
                "Asinan",
                R.drawable.food3
            ),
            item(
                "Sandwich",
                R.drawable.food4
            ),
            item(
                "Sandwich",
                R.drawable.food4
            ),
            item(
                "Sandwich",
                R.drawable.food4
            ),
            item(
                "Asinan",
                R.drawable.food3
            ),
            item(
                "Asinan",
                R.drawable.food3
            )
        )
    }
}