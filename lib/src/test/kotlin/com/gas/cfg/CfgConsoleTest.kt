package com.gas.cfg

import kotlin.test.Test
import kotlin.test.assertTrue

class CfgConsoleTest {
	@Test
	fun testCreateFromArgs() {
		val args = arrayOf<String>("first", "value1",
			"second", "value2","third", "value4")
        val cfg = CfgConsole(args).load()
        val cfgParsingFailedMsg = "Config parsing failed!"
		assertTrue(cfg.prop("first") == "value1", cfgParsingFailedMsg)
		assertTrue(cfg.prop("second") == "value2", cfgParsingFailedMsg)
		assertTrue(cfg.prop("third") == "value4", cfgParsingFailedMsg)
	}
}
