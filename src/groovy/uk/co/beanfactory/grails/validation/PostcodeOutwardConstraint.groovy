package uk.co.beanfactory.grails.validation

import java.util.regex.Pattern

import org.codehaus.groovy.grails.validation.AbstractConstraint
import org.springframework.validation.Errors

class PostcodeOutwardConstraint extends AbstractConstraint {

  static final String DEFAULT_MESSAGE_CODE_LENGTH_INVALID = "default.outward.violation.length.invalid.message"
  static final String DEFAULT_MESSAGE_CODE_FIRST_CHAR = "default.outward.violation.first.char.message"
  static final String DEFAULT_MESSAGE_CODE_2ND_CHAR = "default.outward.violation.second.char.message"
  static final String DEFAULT_MESSAGE_CODE_OTHER_CHARS = "default.outward.violation.other.chars.message"
  static final String NAME = "pc_outward"
  
  private boolean validateConstraint
  
  public void rejectValueWithDefaultMessage(Object target, Errors errors, String defaultMessage, String[] codes, Object[] args) {
      super.rejectValueWithDefaultMessage(target, errors, defaultMessage, codes, args)
      
  }
  
  protected void processValidate(Object target, Object propertyValue, Errors errors) {
    if (validateConstraint && propertyValue) {
      if (!isLengthValid(propertyValue)) {
        println("oops-" + DEFAULT_MESSAGE_CODE_LENGTH_INVALID)
        def args = [constraintPropertyName, constraintOwningClass, propertyValue] as Object[]
        rejectValue(target, errors, DEFAULT_MESSAGE_CODE_LENGTH_INVALID, "${NAME}.violation", args)
      }
      
      if (!isFirstCharValid(propertyValue)) {
        println("oops-" + DEFAULT_MESSAGE_CODE_FIRST_CHAR)
        def args = [constraintPropertyName, constraintOwningClass, propertyValue] as Object[]
        rejectValue(target, errors, DEFAULT_MESSAGE_CODE_FIRST_CHAR, "${NAME}.violation", args)
      }
      
      if (!checkTwoCharOutward(propertyValue)) {
        println("oops-" + DEFAULT_MESSAGE_CODE_2ND_CHAR)
        def args = [constraintPropertyName, constraintOwningClass, propertyValue] as Object[]
        rejectValue(target, errors, DEFAULT_MESSAGE_CODE_2ND_CHAR, "${NAME}.violation", args)
      }
      
      if (!checkOtherStringOptions(propertyValue)) {
        println("oops-" + DEFAULT_MESSAGE_CODE_OTHER_CHARS)
        def args = [constraintPropertyName, constraintOwningClass, propertyValue] as Object[]
        rejectValue(target, errors, DEFAULT_MESSAGE_CODE_OTHER_CHARS, "${NAME}.violation", args)
      }
    }
  }

  void setParameter(Object constraintParameter) {
    if (!(constraintParameter instanceof Boolean)) {
      throw new IllegalArgumentException("Parameter for constraint [$NAME] of property [$constraintPropertyName] of class [$constraintOwningClass] must be a boolean value")
    }
    validateConstraint = constraintParameter
    super.setParameter(constraintParameter)
  }

  boolean supports(Class type) { true }

  String getName() { NAME }

  boolean isLengthValid(String value) {
    if (value == null || value.length() < 2 || value.length() > 4) {
     return false
    }
    return true
  }
  
  /**
   * is only passed upper case due to Postcode setter
   * @param value
   * @return
   */
  boolean isFirstCharValid(String value) {
    return isAChar(value[0])
  }

	private boolean isAChar(String value) {
		if (checkRegex("[A-Z]", value))
		{
			return true
		}
	}
  
  boolean checkOtherStringOptions(String value) {
    if (value.length() == 3) {
      if (isAChar(value[1])) {
        //second char is a char
        // third MUST be a number
        return value[2].isNumber()
      } else {
        // second char is a number
        //third can be either
        return true
      }
    } else {
      if (value.length() == 4) {
        //length must be 4
        //second character MUST be a char
        if (!isAChar(value[1])) {
          return false
        }
        // third MUST be a number
        if (!value[2].isNumber()) {
          return false
        }
      }
      return true
    }
  }
  
  boolean checkTwoCharOutward(String value) {
    if (value.length() == 2)
    {
      //if length is 2 then second char MUST be a number
      return value[1].isNumber()
    } else {
      return true
    }
  }
  
  private boolean checkRegex(String regex, String input) {
    Pattern pattern = Pattern.compile(regex);
    return (pattern.matcher(input).matches());
   }
  
}
