package com.example.rss_aggregator_2022.features.rssmanagement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rss_aggregator_2022.R
import com.example.rss_aggregator_2022.databinding.FragmentRssManagementBinding
import com.example.rss_aggregator_2022.features.rssmanagement.RssManagementFragmentDirections.Companion.actionManagementToUserForm
import com.example.rss_aggregator_2022.features.rssmanagement.adapter.RssManagerAdapter
import com.google.android.material.snackbar.Snackbar

class RssManagementFragment : Fragment() {
    var binding: FragmentRssManagementBinding? = null
    private val managerAdapter = RssManagerAdapter()
    private lateinit var viewModel: RssManagementViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRssManagementBinding.inflate(inflater)
        viewModel = RssManagementFactory().injectRssManagementViewModel(this.requireContext())
        setupView()
        setupObservers()
        viewModel.obtainRss()
        return binding?.root
    }


    private fun setupView() {
        binding?.apply {
            rssSourceFeed.apply {
                adapter = managerAdapter
                layoutManager =
                    LinearLayoutManager(
                        requireContext(),
                        LinearLayoutManager.VERTICAL,
                        false
                    )
            }
            managementToolbar.apply {
                title = getString(R.string.manager_name)
                setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.to_user_form -> {
                            findNavController().navigate(
                                actionManagementToUserForm()
                            )
                        }
                    }
                    true
                }
            }
        }
    }

    private fun setupObservers() {
        val managerRssSubscriber = Observer<RssManagementViewModel.ManagerUiState> { uiState ->
            if (uiState.error != null) {
                uiState.error.let {
                    uiState.error.let {
                        Snackbar.make(
                            binding!!.root,
                            "$uiState.error",
                            Snackbar.LENGTH_LONG
                        )
                    }
                }
            } else {
                managerAdapter.setDataItems(uiState.managerFeed)
            }
        }
        viewModel.managerUiState.observe(viewLifecycleOwner, managerRssSubscriber)
    }


}