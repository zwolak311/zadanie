package zwolinski.bartosz.zadanie.ui.fragments.katowiceTemp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import zwolinski.bartosz.zadanie.R
import zwolinski.bartosz.zadanie.ui.base.BaseViewModelFragment
import zwolinski.bartosz.zadanie.ui.fragments.katowiceTemp.adapter.HomeTemperatureDataAdapter
import javax.inject.Inject

class KatowiceTempFragment : BaseViewModelFragment<KatowiceTempViewModel>() {

    @Inject
    lateinit var homeTemperatureDataAdapter: HomeTemperatureDataAdapter

    override fun getViewModelClass(): Class<KatowiceTempViewModel> = KatowiceTempViewModel::class.java

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRefreshButton()

        setupRecyclerView()

        observeLastKatowiceWeatherData()
    }

    private fun observeLastKatowiceWeatherData() {
        viewModel.observeLastKatowiceTemperatures()
            .observe(viewLifecycleOwner, Observer {
                homeTemperatureDataAdapter.items = viewModel.mapWeatherModelToString(it)
            })
    }

    private fun setupRefreshButton() {
        home_refresh_btn.setOnClickListener {
            viewModel.fetchKatowiceWeatherData()
        }
    }

    private fun setupRecyclerView() {
        home_recycler.setHasFixedSize(true)
        home_recycler.adapter = homeTemperatureDataAdapter
        home_recycler.layoutManager = LinearLayoutManager(requireContext())
    }

}