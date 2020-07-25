package berke.com.kotlinretrofitsample.service

import berke.com.kotlinretrofitsample.adapter.EarthquakeRecyclerViewAdapter
import berke.com.kotlinretrofitsample.model.EarthquakeModel
import berke.com.kotlinretrofitsample.utils.Constants.BASE_URL
import berke.com.kotlinretrofitsample.viewmodels.EarthquakeViewModel
import retrofit2.Retrofit
import kotlin.jvm.java

abstract class EarthquakeInstance {
    companion object {
        private val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build()

        setupViewModel()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        earthquakeAdapter = EarthquakeRecyclerViewAdapter(listOf())
        val dogLayoutManager = GridLayoutManager(
                this,
                2,
                GridLayoutManager.VERTICAL,
                false
        )

        EarthquakeRecyclerViewAdapter.apply {
            adapter = dogLayoutManager
            layoutManager = dogLayoutManager
        }
    }

    private fun setupObserver() {
        EarthquakeViewModel.earthquakeDate.observe(this, Observer { mylist ->
            earthquakeAdapter.mylist = mylist.position
            earthquakeAdapter.notifyDataSetChanged()
        })
    }

    private fun setupViewModel() {
        EarthquakeViewModel = ViewModelProvider(this).get(EarthquakeViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        setupObserver()
    }

}