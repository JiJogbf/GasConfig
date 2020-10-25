package com.gas.cfg

class CfgConsole(val args: Array<String>): Config{
    private var props = mutableMapOf<String, String>()
    
    override fun load(): Config{
		var key: String? = null
		for(s in args){
			if(key != null){
				props.put(key,s)
				key = null
			}else{
				key = s
			}
        }
        return this
    }
        
	override fun prop(key: String): String{       
        return if(props.containsKey(key)) 
            when(val s: String? = props.get(key)){
                null -> ""
                else -> s
            }
        else
            ""
    }
    
    override fun save(): Config{
        return this
    }
}
