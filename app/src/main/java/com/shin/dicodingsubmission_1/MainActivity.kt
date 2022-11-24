package com.shin.dicodingsubmission_1

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.shin.dicodingsubmission_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<User>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Github Users"

        binding.rvUsers.setHasFixedSize(true)
        list.addAll(listUsers)
        showRecyclerList()
    }

    private val listUsers: ArrayList<User> get() {
        val dataFullName = resources.getStringArray(R.array.data_name)
        val dataUserName = resources.getStringArray(R.array.data_user_name)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataPhotoDetail = resources.obtainTypedArray(R.array.data_photo_detail)
        val dataRepo = resources.getStringArray(R.array.data_repo)
        val dataProject  = resources.getStringArray(R.array.data_project)
        val dataFollowers = resources.getStringArray(R.array.data_followers)
        val dataLocation = resources.getStringArray(R.array.data_location)
        val dataCompany = resources.getStringArray(R.array.data_company)
        val dataDescription = resources.getStringArray(R.array.data_description)

        val listUser = ArrayList<User>()
        for (i in dataUserName.indices) {
            val user = User(
                dataFullName[i],
                dataUserName[i],
                dataPhoto.getResourceId(i, -1),
                dataPhotoDetail.getResourceId(i, -1),
                dataRepo[i],
                dataProject[i],
                dataFollowers[i],
                dataLocation[i],
                dataCompany[i],
                dataDescription[i],
            )
            listUser.add(user)
        }
        return listUser
    }

    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            binding.rvUsers.layoutManager = GridLayoutManager(this, 2)
        } else {
            binding.rvUsers.layoutManager = LinearLayoutManager(this)
        }
        val listUserAdapter = ListUserAdapter(list)
        binding.rvUsers.adapter = listUserAdapter
        listUserAdapter.setOnItemClickCallback(object: ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) = showSelectedUser(data)
        })
    }

    private fun showSelectedUser(data: User) {
        val moveObjectWithIntent = Intent(this@MainActivity, UserDetailActivity::class.java)
        moveObjectWithIntent.putExtra(UserDetailActivity.EXTRA_USER_INFO, data)
        startActivity(moveObjectWithIntent)
    }
}