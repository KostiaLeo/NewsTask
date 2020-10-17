package com.example.android_skills.dagger

import com.example.android_skills.dagger.modules.SingletonScopeModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [AndroidSupportInjectionModule::class, AndroidInjectionModule::class, SingletonScopeModule::class]
)
@Singleton
interface AppComponent {
    fun inject(application: App)
}

