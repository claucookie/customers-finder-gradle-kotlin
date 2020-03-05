package datasource

import datasource.model.CustomerInfo

class CustomersLocalDataSource(val customersFileReader: CustomersFileReader) {

    fun getAllCustomers(): MutableList<CustomerInfo> {
        return customersFileReader.retrieveCustomers()
    }

}
