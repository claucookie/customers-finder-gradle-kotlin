import domain.GetCustomersCloseToOfficeUseCase
import domain.GetCustomersRequest

fun main() {
    print("- Reading customers file \n")
    GetCustomersCloseToOfficeUseCase(GetCustomersRequest(100)).execute().forEach {
        println(it)
    }

}