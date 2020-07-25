package berke.com.kotlinretrofitsample.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import berke.com.kotlinretrofitsample.R
import berke.com.kotlinretrofitsample.viewmodels.EarthquakeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import java.util.Observer

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: EarthquakeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(EarthquakeViewModel::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getData()
        }

        viewModel.earthquakes.observe(this, Observer { valList ->
            Log.e(TAG, "$valList")
        })

    }
}
