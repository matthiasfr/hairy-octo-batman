package com.bytecloud.packetManager

import grails.test.mixin.TestFor
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(PacketGroup)
class PacketGroupSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

 void "test name constraints"() {
		when:
		def packetGroup = new PacketGroup()
		packetGroup.validate()
		
		then:
		packetGroup.errors["name"] != null
		
		when:
		packetGroup = new PacketGroup()
		packetGroup.name = "test"
		packetGroup.validate()
		
		then:
		packetGroup.errors["name"] == null
    }
}
