package com.bytecloud.packetManager

class CommunicationComponent {

	String name
	String description
	
    static constraints = {
		name(nullable:false, blank:false)
    }
}
