package datasource

import datasource.model.CustomerInfo
import java.io.File

class CustomersFileReader(private val customerParser: CustomerJsonParser) {

    fun retrieveCustomers(): MutableList<CustomerInfo> {
        val customers = mutableListOf<CustomerInfo>()

        File("customers.txt").forEachLine {
            customers.add(customerParser.parse(it))
        }
        return customers
    }

}

