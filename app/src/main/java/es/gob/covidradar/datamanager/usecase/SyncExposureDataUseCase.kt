package es.gob.covidradar.datamanager.usecase

import es.gob.covidradar.datamanager.repository.ContactTracingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SyncExposureDataUseCase @Inject constructor(private val repository: ContactTracingRepository) {

    fun syncExposureData() {
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO) {
                repository.syncData()
            }
        }
    }

}