import datasource.CustomersLocalDataSource

fun main() {
    // Read file
    print("- Reading customers file \n")
    CustomersLocalDataSource().getAllCustomers().forEach {
        print(it + "\n")
    }
}