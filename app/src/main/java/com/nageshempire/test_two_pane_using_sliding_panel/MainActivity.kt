package com.nageshempire.test_two_pane_using_sliding_panel

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.nageshempire.test_two_pane_using_sliding_panel.ItemDetailFragment.Companion.ARG_ITEM_ID
import com.nageshempire.test_two_pane_using_sliding_panel.databinding.ActivityMainBinding
import com.nageshempire.test_two_pane_using_sliding_panel.placeholder.PlaceholderContent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}