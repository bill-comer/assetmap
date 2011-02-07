package uk.co.beanfactory.grails.validation

import java.util.regex.Pattern

import org.codehaus.groovy.grails.validation.AbstractConstraint
import org.springframework.validation.Errors

class PostcodeInwardConstraint extends PostcodeAbstractConstraint {

  
  static final String DEFAULT_MESSAGE_CODE_LENGTH_INVALID = "default.inward.violation.length.invalid.message"
  
  static final String NAME = "pc_inward"
  
  protected void processValidate(Object target, Object propertyValue, Errors errors) {
    if (validateConstraint && propertyValue) {
      if (isLengthThreeChars(propertyValue)) {
        println("oops-" + DEFAULT_MESSAGE_CODE_LENGTH_INVALID)
        def args = [constraintPropertyName, constraintOwningClass, propertyValue] as Object[]
        rejectValue(target, errors, DEFAULT_MESSAGE_CODE_LENGTH_INVALID, "${NAME}.violation", args)
        }
      
      if(!isFirstCharANumber(propertyValue)) {
        println("oops-" + DEFAULT_MESSAGE_CODE_LENGTH_INVALID)
        def args = [constraintPropertyName, constraintOwningClass, propertyValue] as Object[]
        rejectValue(target, errors, DEFAULT_MESSAGE_CODE_LENGTH_INVALID, "${NAME}.violation", args)
        }
      
      if(!isSecondThirdLetters(propertyValue)) {
        println("oops-" + DEFAULT_MESSAGE_CODE_LENGTH_INVALID)
        def args = [constraintPropertyName, constraintOwningClass, propertyValue] as Object[]
        rejectValue(target, errors, DEFAULT_MESSAGE_CODE_LENGTH_INVALID, "${NAME}.violation", args)
        }
      }
  }

  String getName() { NAME }
  
  boolean isLengthThreeChars(String value) {
    if (value == null || value.length() != 3) {
      return false
    }
    return true
  }
  
  boolean isFirstCharANumber(String value) {
    return value[0].isNumber()
  }
  
  
  boolean isSecondThirdLetters(String value) {
    if (!isAChar(value[1])) {
      return false
    }
    if (!isAChar(value[2])) {
      return false
    }
    return true
  }

  
}
