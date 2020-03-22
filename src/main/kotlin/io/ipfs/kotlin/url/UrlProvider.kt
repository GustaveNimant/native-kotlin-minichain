package io.ipfs.kotlin.url

import io.ipfs.kotlin.*
// import java.io.File
// import java.util.Stack

/**
 * What is it : the Provider providing an Url knowing its urlType.
 * Example : (LocalIpfsApi, "127.0.0.1:5001") 
 * Author : Emile Achadde 25 février 2020 at 19:03:02+01:00
 * Revision : make by Emile Achadde 28 février 2020 at 09:46:19+01:00
 */

class UrlProvider {

    val register = UrlRegister
    
    private fun build(hosVal: HostValue, porVal: PortValue): UrlValue {
	val (here, caller) = moduleHereAndCaller()
	entering(here, caller)
	
	if(isTrace(here)) println ("$here: input hosVal '$hosVal'")
	if(isTrace(here)) println ("$here: input porVal '$porVal'")
    
	val result = UrlValue(hosVal, porVal)
	
	if(isTrace(here)) println ("$here: output UrlValue $result")
	
	exiting(here)
	return result
    }

    fun portTypeFromParameterMap(): PortType {
	val (here, caller) = moduleHereAndCaller()
	entering(here, caller)
	
	val result = 
	    if (ParameterMap.containsKey("port")) { 
              val wor = ParameterMap.getValue("port").first() // -port <type> [<integer>] 
	      PortType.make(wor)
	    }
	else {
	    PortType.PortWebui
	}
	
	if(isTrace(here)) println ("$here: output result $result")

	exiting(here)
	return result 
    }

    private fun hostTypeFromParameterMap(): HostType {
	val (here, caller) = moduleHereAndCaller()
	entering(here, caller)
	
	val result = 
	    if (ParameterMap.containsKey("host")) {
		val wor = ParameterMap.getValue("host").first() // -host <type> <hostname>
		HostType.make (wor)
	    }
	else {
               HostType.HostLocal
	}

	if(isTrace(here)) println ("$here: output result $result")
	return result 
    }
    
    private fun buildAndStoreUrl(urlTyp: UrlType, hosVal: HostValue, porVal: PortValue): UrlValue {
	val (here, caller) = moduleHereAndCaller()
	entering(here, caller)

	if(isTrace(here)) println ("$here: input urlTyp '$urlTyp'")
	if(isTrace(here)) println ("$here: input hosVal '$hosVal'")
	if(isTrace(here)) println ("$here: input porVal '$porVal'")
    
	val result = build(hosVal, porVal)
	register.store (urlTyp, result)
	
	exiting(here)
	return result
    }
    
    public fun provideOfUrlType(urlTyp: UrlType) : UrlValue {
	val (here, caller) = moduleHereAndCaller()
	entering(here, caller)

	val result = 
	    if (register.isStored(urlTyp)){
		register.retrieve(urlTyp)!!
	    }
	    else {
		val hosTyp = hostTypeFromParameterMap() 
		val hosVal = HostProvider().provideOfHostType(hosTyp)   

		val porTyp = portTypeFromParameterMap() 
		val porVal = PortProvider().provideOfPortType(porTyp)   

		buildAndStoreUrl(urlTyp, hosVal, porVal)
	}
		
	println()
	println(urlTyp.toString()+" => '$result'")
	println()

	exiting(here)
	return result
    }

    public fun printOfUrlType (urlTyp: UrlType) {
	val (here, caller) = moduleHereAndCaller()
	entering(here, caller)
	
	val url = provideOfUrlType(urlTyp)
	val str = url.toString()
	println ("urlType $urlTyp => $str")
	exiting(here)
    }
}
