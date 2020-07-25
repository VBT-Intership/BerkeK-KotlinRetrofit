package berke.com.kotlinretrofitsample.viewmodels


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import berke.com.kotlinretrofitsample.model.EarthquakeModel
import berke.com.kotlinretrofitsample.service.EarthquakeInstance
import kotlinx.coroutines.launch

private const val TAG = "Earthquake View Model"

class EarthquakeViewModel : ViewModel() {

    private var _earthquakes = MutableLiveData<EarthquakeModel>()
    val earthquakes: LiveData<EarthquakeModel>
        get() = _earthquakes


    init {
        getData()
    }

    fun getData() {
        viewModelScope.launch {
            try {
                _earthquakes.value = EarthquakeInstance.retrofitInstance.getAllEarthquakes()
            } catch (e: Exception) {
                Log.e(TAG, "${e.message}")
            }
        }
    }

}