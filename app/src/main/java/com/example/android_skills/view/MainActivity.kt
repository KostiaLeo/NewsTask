package com.example.android_skills.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.android_skills.R
import com.example.android_skills.view.fragments.SectionPagerAdapter
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }

    private fun initUI() {
        val sectionPagerAdapter = SectionPagerAdapter(supportFragmentManager)
        viewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionPagerAdapter
        tabs.setupWithViewPager(viewPager)
        viewPager.offscreenPageLimit = 2
    }
}
