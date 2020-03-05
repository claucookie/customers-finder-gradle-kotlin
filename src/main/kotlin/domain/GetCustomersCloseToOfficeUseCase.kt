package domain

import datasource.CustomerJsonParser
import datasource.CustomersFileReader
import datasource.CustomersLocalDataSource
import datasource.model.CustomerInfo
import domain.DistanceCalculator.distanceBetweenCoordinates

class GetCustomersCloseToOfficeUseCase(private val request: GetCustomersRequest) {

    fun execute(): List<CustomerInfo> {
        return CustomersLocalDataSource(CustomersFileReader(CustomerJsonParser()))
            .getAllCustomers()
            .filter { it.isCloserThan(request.distanceInMeters) }
            .sortedBy { it.user_id }
    }

    private fun CustomerInfo.isCloserThan(expectedDistanceInKms: Int): Boolean {
        val officeLat = 53.339428
        val officeLong = -6.257664
        val distanceInKms = distanceBetweenCoordinates(officeLat, officeLong, latitude, longitude, "K")
        return distanceInKms <= expectedDistanceInKms
    }

}

class GetCustomersRequest(
    val distanceInMeters: Int
)
