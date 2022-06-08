package com.example.airbnb.common

import com.example.airbnb.data.mainrepository.MainDataSource
import com.example.airbnb.data.mainrepository.MainMainDataSourceImpl
import com.example.airbnb.data.searchresultrepository.SearchResultDataSource
import com.example.airbnb.data.searchresultrepository.SearchResultDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BindModule {

    @Binds
    abstract fun bindMainRepository(mainDataSourceImpl: MainMainDataSourceImpl): MainDataSource

    @Binds
    abstract fun bindSearchResultRepository(searchResultDataSourceImpl: SearchResultDataSourceImpl): SearchResultDataSource
}