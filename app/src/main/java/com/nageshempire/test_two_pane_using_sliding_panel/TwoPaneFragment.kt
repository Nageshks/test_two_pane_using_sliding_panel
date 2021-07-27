package com.nageshempire.test_two_pane_using_sliding_panel

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import com.nageshempire.test_two_pane_using_sliding_panel.databinding.TpFragmentBinding
import com.nageshempire.test_two_pane_using_sliding_panel.placeholder.PlaceholderContent

class TwoPaneFragment : Fragment(R.layout.tp_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = TpFragmentBinding.bind(view)

        // Connect the SlidingPaneLayout to the system back button.
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            TwoPaneOnBackPressedCallback(binding.slidingPaneLayout)
        )

        // Setup the RecyclerView adapter, etc.
        setupList(binding)
    }

    private fun setupList(binding: TpFragmentBinding) {
        binding.listPane.withModels {
            PlaceholderContent.ITEMS.forEach {
                myItem {
                    id(it.id)
                    data(it)
                    onClickContent { _ ->
                        openDetails(binding, it.id)
                    }
                }
            }
        }
    }

    private fun openDetails(binding: TpFragmentBinding, itemId: String) {
        childFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.epoxy_detail_container, ItemDetailFragment.newInstance(itemId))
            if (binding.slidingPaneLayout.isOpen) {
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            }
        }
        binding.slidingPaneLayout.open()
    }

}