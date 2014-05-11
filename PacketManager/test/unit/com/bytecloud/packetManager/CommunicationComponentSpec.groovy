package com.bytecloud.packetManager

import com.bytecloud.DomainSpecification;

import grails.test.mixin.TestFor
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
//@TestMixin(GrailsUnitTestMixin)
@TestFor(CommunicationComponent)
class CommunicationComponentSpec extends DomainSpecification {

    def setup() {
    }

    def cleanup() {
    }

	void "name constraint nullable false"() {
		setup:
		def communicationComponent = new CommunicationComponent()

		when:
		communicationComponent.name = null
		communicationComponent.validate()

		then:
		hasFieldContraintError(communicationComponent, "name", "nullable")

		when:
		communicationComponent.name = "testName"
		communicationComponent.validate()

		then:
		!hasFieldContraintError(communicationComponent, "name", "nullable")
	}
	
	void "name constraint blank false"() {
		setup:
		def communicationComponent = new CommunicationComponent()

		when:
		communicationComponent.name = ""
		communicationComponent.validate()

		then:
		hasFieldContraintError(communicationComponent, "name", "blank")

		when:
		communicationComponent.name = "testName"
		communicationComponent.validate()

		then:
		!hasFieldContraintError(communicationComponent, "name", "blank")
	}
}
