package com.example.data.di

import android.content.Context
import com.example.data.repo.BeneficiariesRepo
import com.example.data.repo.BeneficiariesRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Provides
    fun provideBeneficiariesRepo(context: Context): BeneficiariesRepo {
        return BeneficiariesRepoImpl(context)
    }
}