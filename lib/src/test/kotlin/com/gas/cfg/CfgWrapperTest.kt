package com.gas.cfg

import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertNotNull

class CfgWrapperTest {

    class CfgLogging(origin: Config, val list: MutableList<Int>): CfgWrapper(origin){
        override fun load(): Config{
            list.add(1)
            super.load()
            return this
        }

        override fun prop(key: String): String{
            list.add(2)
            return super.prop(key)
        }

        override fun save(): Config{
            list.add(3)
            super.save()
            return this
        }
    }

	@Test
	fun testing() {
        val args = arrayOf<String>("first", "second", "third")
        val list = mutableListOf<Int>()
        val cfg = CfgLogging(CfgConsole(args), list).load()
        val prop = cfg.prop("test")
        cfg.save()
        assertTrue(list.size == 3, "list.size=${list.size}")
	}
}
