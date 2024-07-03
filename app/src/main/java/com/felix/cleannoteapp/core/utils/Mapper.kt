package com.felix.cleannoteapp.core.utils

interface Mapper<K, V> {

    fun mapToDomain(data : K) : V


    fun mapToEntity(data : V) : K
}