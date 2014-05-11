package com.bytecloud.packetManager

class Field {

	String name
	FieldType type
	String description
	int sortKey
	
	static hasMany = [arrayFields:Field]
	
    static constraints = {
		name(nullable:false, blank:false)
		type(nullable:false, validator:{value, object ->
			if(value != FieldType.ARRAY) {
				if(object.arrayFields && object.arrayFields.size() > 0) {
					return "arrayField.not.allowed"
				}
			} 
		})
		sortKey(min:0)
    }
	
}
