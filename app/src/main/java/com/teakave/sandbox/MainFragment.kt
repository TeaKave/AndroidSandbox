package com.teakave.sandbox

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.teakave.sandbox.homescreen.HomeScreenWallpaperActivity
import com.teakave.sandbox.menu.adapter.MenuItemsAdapter
import com.teakave.sandbox.menu.model.MenuItem
import com.teakave.sandbox.menu.model.MenuItem.HOME_SCREEN_WALLPAPER
import com.teakave.sandbox.menu.model.MenuItem.TRANSPARENCY_SLIDER

class MainFragment : Fragment(), MenuItemsAdapter.Interaction {

    lateinit var adapter: MenuItemsAdapter

    private val menuItems = listOf(
        HOME_SCREEN_WALLPAPER,
        TRANSPARENCY_SLIDER
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = MenuItemsAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layoutContainer = inflater.inflate(R.layout.fragment_main, container, false)
        setupMenu(layoutContainer)
        return layoutContainer
    }

    private fun setupMenu(layoutContainer: View) {
        val menuList = layoutContainer.findViewById<RecyclerView>(R.id.recycler_menu)
        menuList.apply {
            layoutManager = LinearLayoutManager(layoutContainer.context)
            adapter = this@MainFragment.adapter
        }

        adapter.submitList(menuItems)
    }

    override fun onItemSelected(position: Int, item: MenuItem) {
        if (item == HOME_SCREEN_WALLPAPER) {
            startActivity(Intent(requireContext(), HomeScreenWallpaperActivity::class.java))
        } else if (item == TRANSPARENCY_SLIDER) {
            findNavController().navigate(R.id.toTransparencySliderFragment)
        }
    }

}
