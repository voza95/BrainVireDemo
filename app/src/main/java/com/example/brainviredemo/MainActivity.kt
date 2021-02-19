package com.example.brainviredemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.brainviredemo.adapter.MainListAdapter
import com.example.brainviredemo.retrofit.ApiInterface
import com.example.brainviredemo.retrofit.AppClient
import com.example.brainviredemo.retrofit.response.MainListResponse
import com.example.brainviredemo.util.AppUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val appClient = AppClient.getClient(this@MainActivity)
    private val apiInterface = appClient.create(ApiInterface::class.java)

    lateinit var rates: HashMap<String, HashMap<String, Double>>
    var mListAdapter: MainListAdapter?= null

    lateinit var mainListingRV: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rates =  HashMap<String, HashMap<String, Double>>()

        mainListingRV = findViewById(R.id.mainListingRV)
        getMainList()
    }

    private fun showDialog() {
        AppUtil.showProgressHUD(this@MainActivity)
    }

    private fun hideDialog() {
        AppUtil.hideProgressHud()
    }

    @SuppressLint("CheckResult")
    fun getMainList(){

        try {
            showDialog()
            val observable = apiInterface.getHistoryList("2018-01-01","2018-09-01")
            observable.enqueue(object: Callback<MainListResponse> {
                override fun onResponse(
                    call: Call<MainListResponse>,
                    response: Response<MainListResponse>
                ) {
                    hideDialog()
                    if (response.isSuccessful){
                        if (!response.body()?.rates.isNullOrEmpty()){
                            rates = response.body()?.rates!!
                            mListAdapter = MainListAdapter(this@MainActivity,rates)
                            mainListingRV.adapter = mListAdapter
                        }
                    }

                }

                override fun onFailure(call: Call<MainListResponse>, t: Throwable) {
                    hideDialog()
                    t.printStackTrace()
                }

            })
        }catch (e:Exception){
            hideDialog()
            e.printStackTrace()
        }
    }
}