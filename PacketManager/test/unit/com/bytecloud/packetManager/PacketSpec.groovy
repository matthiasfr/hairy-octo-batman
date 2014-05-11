package com.bytecloud.packetManager

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class PacketSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

 void "test name constraints"() {
		when:
		def packet = new Packet()
		packet.validate()
		
		then:
		packet.errors["name"] != null
		
		when:
		packet = new Packet()
		packet.name = "test"
		packet.validate()
		
		then:
		packet.errors["name"] == null
    }
}
