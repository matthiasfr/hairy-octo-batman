
package com.bytecloud

import spock.lang.Specification

class DomainSpecification extends Specification {
	public boolean hasFieldContraintError(Object domain, String fieldName, String constraintName) {
		boolean error = false
		
		if(domain.hasErrors()) {
			domain.errors.getFieldError(fieldName).each() { fieldError ->
				if(constraintName.equals(fieldError.getCode())) {
					error = true
				}
			}
		}
		
		return error
	}
}
