package uk.co.beanfactory.grails.validation

import java.util.regex.Pattern

import org.codehaus.groovy.grails.validation.AbstractConstraint
import org.springframework.validation.Errors

abstract class PostcodeAbstractConstraint extends AbstractConstraint {

  boolean validateConstraint
  
  void setParameter(Object constraintParameter) {
    if (!(constraintParameter instanceof Boolean)) {
      throw new IllegalArgumentException("Parameter for constraint [$NAME] of property [$constraintPropertyName] of class [$constraintOwningClass] must be a boolean value")
    }
    validateConstraint = constraintParameter
    super.setParameter(constraintParameter)
  }

  boolean supports(Class type) { true }

	boolean isAChar(String value) {
		if (checkRegex("[A-Z]", value))
		{
			return true
		}
	}
  
  
  boolean checkRegex(String regex, String input) {
    Pattern pattern = Pattern.compile(regex);
    return (pattern.matcher(input).matches());
   }
  
}
