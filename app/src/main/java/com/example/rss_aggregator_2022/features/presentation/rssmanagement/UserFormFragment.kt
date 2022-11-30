package com.example.rss_aggregator_2022.features.presentation.rssmanagement

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.rss_aggregator_2022.R
import com.example.rss_aggregator_2022.databinding.UserFormViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class UserFormFragment : BottomSheetDialogFragment() {
    private var binding: UserFormViewBinding? = null

    private val viewModel by lazy {
        this.activity?.let {
            RssManagementFactory().saveUserRss(it.getPreferences(Context.MODE_PRIVATE))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UserFormViewBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    private fun setupView() {
        binding?.apply {
            bottomsheetButtonCancel.setOnClickListener() {
                findNavController().navigateUp()
            }
            bottomsheetButtonSave.setOnClickListener() {
                viewModel?.saveRss(
                    inputName.text.toString(),
                    inputUrl.text.toString()
                )
                findNavController().navigateUp()
                showSnackBar()

            }
        }
    }
    private fun showSnackBar(){
        Snackbar.make((requireActivity()).findViewById<ViewGroup>(R.id.main_fragment_view),
        R.string.added_record,
        BaseTransientBottomBar.LENGTH_SHORT).show()
    }
}
