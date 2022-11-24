package com.example.rss_aggregator_2022.features.presentation.rssmanagement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rss_aggregator_2022.databinding.FragmentRssManagementBinding
import com.example.rss_aggregator_2022.databinding.UserFormViewBinding

class UserFormFragment:Fragment() {
    private var binding: UserFormViewBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UserFormViewBinding.inflate(inflater)
        return binding?.root
    }

}