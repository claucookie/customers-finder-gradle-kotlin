package datasource

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import datasource.model.CustomerInfo

class CustomerJsonParser {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    fun parse(customerJsonSerialized: String): CustomerInfo {
        return moshi.adapter<CustomerInfo>(CustomerInfo::class.java).fromJson(customerJsonSerialized) as CustomerInfo
    }

}