package io.ipfs.kotlin

fun callerName(): String {
    val sta = Thread.currentThread().stackTrace
    val result = 
	try {
	    (sta[3]).getMethodName()
	}
    catch (e: Exception) {
	"None"}

    return result	
}

fun functionName(): String {
    val sta = Thread.currentThread().stackTrace[2]
    val str = sta.getMethodName()
    return str	
}

fun hereAndCaller(): Pair<String, String> {
    val sta = Thread.currentThread().stackTrace
    val here = (sta[2]).getMethodName()
    val caller = 
	try {
	    (sta[3]).getMethodName()
	}
    catch (e: Exception) {
	"None"}
    
    val result = Pair(here, caller) 
    return result
}

fun moduleName(): String {
    val sta = Thread.currentThread().stackTrace[2]
    val str = sta.getFileName()
    val result = str.replace(".kt", "")  
    return result
}

fun moduleAndfunctionName(): Pair<String, String> {
    val sta = Thread.currentThread().stackTrace[2]
    val strFun = sta.getMethodName()
    val strFil = sta.getFileName()
    val strMod = strFil.replace(".kt", "")  
    return Pair(strMod, strFun)
}

fun moduleAndHereAndCaller(): Triple<String, String, String> {
    val sta = Thread.currentThread().stackTrace
    val strFil = (sta[2]).getFileName()
    val module = strFil.replace(".kt", "")  
    val here = (sta[2]).getMethodName()
    val caller = 
	try {
	    (sta[3]).getMethodName()
	}
    catch (e: Exception) {
	"None"}
    
    val result = Triple(module, here, caller) 
    return result
}

fun moduleHereAndCaller(): Pair<String, String> {
    val sta = Thread.currentThread().stackTrace
    val strFil = (sta[2]).getFileName()
    val module = strFil.replace(".kt", "")  
    val here = (sta[2]).getMethodName()
    val caller = 
	try {
	    (sta[3]).getMethodName()
	}
    catch (e: Exception) {
	"None"}
    
    val result = Pair(module+"."+here, caller) 
    return result
}

