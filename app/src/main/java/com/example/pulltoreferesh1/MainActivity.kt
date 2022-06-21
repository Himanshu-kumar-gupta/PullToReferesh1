package com.example.pulltoreferesh1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MainActivity : AppCompatActivity() {

    //The below variables are to be late-initialized. Hence, lateinit is used
    //Creating variable for pull to refresh layout, recycler view, adapter and
    //list of numbers in string format
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    lateinit var pullNum: RecyclerView
    lateinit var pullTRAdapter: PtrAdapter
    lateinit var numbers: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initializing views with respective ids in below lines
        swipeRefreshLayout = findViewById(R.id.android_container)
        pullNum = findViewById(R.id.recycle_id)

        //Initializing list
        numbers= ArrayList<String>()

        //Initializing adapter
        pullTRAdapter = PtrAdapter(numbers, this)

        //Configuring adapter to recycler view in below line
        pullNum.adapter=pullTRAdapter

        //Adding pre-display data to list
        numbers.add("1")
        numbers.add("2")
        numbers.add("3")
        numbers.add("4")
        numbers.add("5")
        numbers.add("6")
        numbers.add("7")

        //The next number to display
        var count:Int=8

        //Notifying adapter that data is changed, in below line
        pullTRAdapter.notifyDataSetChanged()

        //Adding refresh listener for pull to refresh functionality in below lines
        swipeRefreshLayout.setOnRefreshListener {

            // Setting refreshing to false so that it doesn't run at all times
            swipeRefreshLayout.isRefreshing = false

            // Adding the next number to list and incrementing the number
            numbers.add(count.toString())
            count++

            //Notifying adapter that data is changed, in below line
            pullTRAdapter.notifyDataSetChanged()
        }
    }
}