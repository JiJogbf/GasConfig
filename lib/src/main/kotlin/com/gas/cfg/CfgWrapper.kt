package com.gas.cfg

open class CfgWrapper(protected val origin: Config): Config{   
    override fun load(): Config{
        return origin.load()
    }

    override fun prop(key: String): String{
        return origin.prop(key)
    }

    override fun save(): Config{
        return origin.save()
    }
}
