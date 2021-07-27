package com.nageshempire.test_two_pane_using_sliding_panel

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.nageshempire.test_two_pane_using_sliding_panel.databinding.ItemDetailFragmentBinding
import com.nageshempire.test_two_pane_using_sliding_panel.placeholder.PlaceholderContent

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [ItemListFragment]
 * in two-pane mode (on larger screen devices) or self-contained
 * on handsets.
 */
class ItemDetailFragment : Fragment(R.layout.item_detail_fragment) {

    private var item: PlaceholderContent.PlaceholderItem? = null
    lateinit var itemDetailTextView: TextView
    private var _binding: ItemDetailFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                item = PlaceholderContent.ITEM_MAP[it.getString(ARG_ITEM_ID)]
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = ItemDetailFragmentBinding.bind(view)
        binding.toolbarLayout?.title = item?.content
        itemDetailTextView = binding.itemDetail
        item?.let {
            itemDetailTextView.text = it.details
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val ARG_ITEM_ID = "item_id"
        fun newInstance(itemId : String) : ItemDetailFragment = ItemDetailFragment().also {
            it.arguments = bundleOf(ARG_ITEM_ID to itemId)
        }
    }

}