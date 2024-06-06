package com.example.data.di

import com.example.data.usecase.GetBeneficiariesUseCase
import com.example.data.usecase.GetBeneficiariesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Singleton
    @Provides
    fun provideGetBeneficiariesUseCase(getBeneficiariesUseCaseImpl: GetBeneficiariesUseCaseImpl): GetBeneficiariesUseCase{
        return getBeneficiariesUseCaseImpl
    }
}