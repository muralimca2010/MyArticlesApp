package com.myarticlesapp.presentation

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.android.post.databinding.ActivityMainBinding
import com.android.post.utils.isNetworkAvailable
import kotlinx.android.synthetic.main.activity_Main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.ext.android.viewModel
import com.myarticlesapp.R

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private var mAdapter: MainAdapter? = MainAdapter()
    private val postViewModel: MainViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_Main)

        activityMainBinding.MainRecyclerView.adapter = mAdapter

        if (isNetworkAvailable()) {
            postViewModel.getMain()
        } else {
            Toast.makeText(
                this,
                getString(R.string.no_internet_connection),
                LENGTH_SHORT
            ).show()
        }

        with(postViewModel) {

            MainData.observe(this@MainActivity, Observer {
                activityMainBinding.MainProgressBar.visibility = GONE
                mAdapter?.mPostList = it
            })

            messageData.observe(this@MainActivity, Observer {
                Toast.makeText(this@MainActivity, it, LENGTH_LONG).show()
            })

            showProgressbar.observe(this@MainActivity, Observer { isVisible ->
                Main_progress_bar.visibility = if (isVisible) VISIBLE else GONE
            })
        }
    }


    override fun onDestroy() {
        mAdapter = null
        super.onDestroy()
    }

    companion object {
        private val TAG = MainActivity::class.java.name
    }
}