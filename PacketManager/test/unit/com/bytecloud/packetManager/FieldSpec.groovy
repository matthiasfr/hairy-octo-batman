package com.bytecloud.packetManager

import com.bytecloud.DomainSpecification;

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class FieldSpec extends DomainSpecification {

    def setup() {
    }

    def cleanup() {
    }

	void "name constraint nullable false"() {
		setup:
		def field = new Field()

		when:
		field.name = null
		field.validate()

		then:
		hasFieldContraintError(field, "name", "nullable")

		when:
		field.name = "testName"
		field.validate()

		then:
		!hasFieldContraintError(field, "name", "nullable")
	}
	
	void "name constraint blank false"() {
		setup:
		def field = new Field()

		when:
		field.name = ""
		field.validate()

		then:
		hasFieldContraintError(field, "name", "blank")

		when:
		field.name = "testName"
		field.validate()

		then:
		!hasFieldContraintError(field, "name", "blank")
	}
	
	void "type constraint nullable false"() {
		setup:
		def field = new Field()

		when:
		field.type = null
		field.validate()

		then:
		hasFieldContraintError(field, "type", "nullable")

		when:
		field.type = FieldType.RAW
		field.validate()

		then:
		!hasFieldContraintError(field, "type", "nullable")
	}
	
	void "sortKey constraint min 0"() {
		setup:
		def field = new Field()

		when:
		field.sortKey = -1
		field.validate()

		then:
		hasFieldContraintError(field, "sortKey", "min.notmet")

		when:
		field.sortKey = 0
		field.validate()

		then:
		!hasFieldContraintError(field, "sortKey", "min.notmet")
	}
	
	void "arrayFields constraint validator"() {
		setup:
		def field = new Field()
		field.addToArrayFields(new Field());

		when:
		field.type = FieldType.RAW
		field.validate()
		
		then:
		hasFieldContraintError(field, "type", "arrayField.not.allowed")

		when:
		field.type = FieldType.ARRAY
		field.validate()

		then:
		!hasFieldContraintError(field, "type", "arrayField.not.allowed")
	}
}
