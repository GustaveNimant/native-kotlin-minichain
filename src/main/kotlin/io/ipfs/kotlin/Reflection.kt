package io.ipfs.kotlin

fun callerName(): String {
    val result = "None"
    return result	
}

fun functionName(): String {
    val result = "None"
    return result	
}

fun hereAndCaller(): Pair<String, String> {
   val result = Pair("None", "None") 
    return result
}

fun moduleName(): String {
    val result = "None"
    return result
}

fun moduleAndfunctionName(): Pair<String, String> {
    val result = Pair("None", "None")
    return result
}

fun moduleAndHereAndCaller(): Triple<String, String, String> {
    val result = Triple("None","None","None")
    return result
}

fun moduleHereAndCaller(): Pair<String, String> {
     val result = Pair("None", "None")
    return result
}


