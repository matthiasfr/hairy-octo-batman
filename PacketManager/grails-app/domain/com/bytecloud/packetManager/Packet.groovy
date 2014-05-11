package com.bytecloud.packetManager

class Packet {
	String name
	String description
	Short packetTypeId
	Integer sinceVersion
	
	static belongsTo = [packetGroup:PacketGroup]
	
	static hasMany = [fields:Field,possibleRequests:Packet, possibleResponse:Packet]
	
    static constraints = {
//		name(nulßlable:false, blank:false)
		
    }
}
