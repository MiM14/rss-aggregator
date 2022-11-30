package com.example.rss_aggregator_2022.features.presentation.rssmanagement

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.rss_aggregator_2022.R
import com.example.rss_aggregator_2022.app.commons.GsonJSerializer
import com.example.rss_aggregator_2022.databinding.UserFormViewBinding
import com.example.rss_aggregator_2022.features.data.local.xml.XmlLocalDataSource
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserFormFragment : BottomSheetDialogFragment() {

    private var binding: UserFormViewBinding? = null
    private var viewModel: RssManagementViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UserFormViewBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = RssManagementFactory().saveUserRss(
            requireContext().getSharedPreferences("", Context.MODE_PRIVATE)
        )
    }

    private fun setupView() {
        binding?.apply {
            bottomsheetButtonCancel.setOnClickListener {
                findNavController().navigateUp()
            }

            bottomsheetButtonSave.setOnClickListener {
                viewModel?.saveRss(
                    inputName.text.toString(),
                    inputUrl.text.toString()
                )
                findNavController().navigateUp()
                showSnackBar()

            }
        }
    }

    private fun showSnackBar() {
        Snackbar.make(
            (requireActivity()).findViewById<ViewGroup>(R.id.main_fragment_view),
            R.string.added_rss_source,
            BaseTransientBottomBar.LENGTH_SHORT
        ).show()
    }
}
