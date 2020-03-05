package datasource

import java.io.File

class CustomersLocalDataSource {

    fun getAllCustomers(): MutableList<String> {
        val customers = mutableListOf<String>()
        File("customers.txt").forEachLine {
            customers.add(it)
        }
        return customers
    }

}
