package com.gas.cfg

interface Config {   
    fun load(): Config
    fun prop(key: String): String
    fun save(): Config
}
