package com.example.android_skills.dagger.modules

import com.example.android_skills.dagger.ActivityScope
import com.example.android_skills.model.TopNewsRepository
import com.example.android_skills.model.source.ItemsApi
import com.example.android_skills.view.MainActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import retrofit2.Retrofit

@Module(includes = [FragmentBuilderModule::class])
class ActivityModule {

    @ActivityScope
    @Provides
    fun provideApi(retrofit: Retrofit) = retrofit.create(ItemsApi::class.java)

    @Provides
    @ActivityScope
    fun provideRepository(api: ItemsApi) = TopNewsRepository(api)
}

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    abstract fun contributeActivityAndroidInjector(): MainActivity
}