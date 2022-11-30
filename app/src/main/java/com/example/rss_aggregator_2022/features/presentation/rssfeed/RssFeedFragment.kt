package com.example.rss_aggregator_2022.features.presentation.rssfeed

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rss_aggregator_2022.app.commons.GsonJSerializer
import com.example.rss_aggregator_2022.databinding.FragmentRssFeedBinding
import com.example.rss_aggregator_2022.features.data.local.xml.XmlLocalDataSource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RssFeedFragment : Fragment() {
    var binding: FragmentRssFeedBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRssFeedBinding.inflate(inflater)
        GlobalScope.launch {
            val list = XmlLocalDataSource(
                requireContext().getSharedPreferences(
                    "",
                    Context.MODE_PRIVATE
                ), GsonJSerializer()
            ).getList()
            Log.d("@dev","$list")
            }
        return binding?.root
    }
}