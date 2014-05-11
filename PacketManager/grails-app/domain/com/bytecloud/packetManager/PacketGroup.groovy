package com.bytecloud.packetManager


class PacketGroup {
	String name
	String description
	
	CommunicationComponent receiver
	CommunicationComponent transmitter
	static hasMany = [packets:Packet]

    static constraints = {
//		name(nullable:false, blank:false)
    }
}
