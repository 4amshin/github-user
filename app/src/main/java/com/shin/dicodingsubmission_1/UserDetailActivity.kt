package com.shin.dicodingsubmission_1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class UserDetailActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_USER_INFO = "extra_user_info"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        supportActionBar?.title = "User Detail"

        val tvUserName: TextView = findViewById(R.id.tv_user_name)
        val tvFullName: TextView = findViewById(R.id.tv_full_name)
        val tvRepo: TextView = findViewById(R.id.tv_repo_amount)
        val tvProject: TextView = findViewById(R.id.tv_project_amount)
        val tvFollowers: TextView = findViewById(R.id.tv_follower_amount)
        val tvLocation: TextView = findViewById(R.id.tv_user_location)
        val tvCompany: TextView = findViewById(R.id.tv_user_company)
        val tvDescription: TextView = findViewById(R.id.tv_description)
        val imgUser: ImageView = findViewById(R.id.user_img)

        val user = intent.getParcelableExtra<User>(EXTRA_USER_INFO) as User
        tvUserName.text = user.userName.toString()
        tvFullName.text = user.fullName.toString()
        tvRepo.text = user.repo.toString()
        tvProject.text = user.project.toString()
        tvFollowers.text = user.followers.toString()
        tvLocation.text = user.location.toString()
        tvCompany.text = user.company.toString()
        tvDescription.text = user.description.toString()
        imgUser.setImageResource(user.photoDetail)

        val btnGithubPages: Button = findViewById(R.id.bt_github_pages)
        btnGithubPages.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.bt_github_pages ->{
                val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/4amshin/"))
                startActivity(i)
            }
        }
    }
}