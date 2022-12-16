package com.example.rss_aggregator_2022.features.rssmanagement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.rss_aggregator_2022.R
import com.example.rss_aggregator_2022.databinding.FragmentRssManagementBinding
import com.example.rss_aggregator_2022.features.rssmanagement.RssManagementFragmentDirections.Companion.actionManagementToUserForm

class RssManagementFragment : Fragment() {
    var binding: FragmentRssManagementBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRssManagementBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    private fun setupView() {
        binding?.managementToolbar?.apply {
            title = getString(R.string.manager_name)
            setOnMenuItemClickListener {
                if (R.id.to_user_form == it.itemId) {
                        findNavController().navigate(
                            actionManagementToUserForm()
                        )
                }
                true
            }
        }
    }
}