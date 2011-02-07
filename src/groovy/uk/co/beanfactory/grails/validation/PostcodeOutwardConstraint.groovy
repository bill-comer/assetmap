package uk.co.beanfactory.grails.validation

import java.util.regex.Pattern

import org.codehaus.groovy.grails.validation.AbstractConstraint
import org.springframework.validation.Errors

class PostcodeOutwardConstraint extends AbstractConstraint {

  static final String DEFAULT_MESSAGE_CODE = "default.outward.violation.message"
  static final String NAME = "pc_outward"
  
  private boolean validateConstraint
  
  public void rejectValueWithDefaultMessage(Object target, Errors errors, String defaultMessage, String[] codes, Object[] args) {
      super.rejectValueWithDefaultMessage(target, errors, defaultMessage, codes, args)
      
  }
  
  protected void processValidate(Object target, Object propertyValue, Errors errors) {
    if (validateConstraint && propertyValue) {
      if (!isLengthValid(propertyValue)) {
        def args = [constraintPropertyName, constraintOwningClass, propertyValue] as Object[]
        rejectValue(target, errors, DEFAULT_MESSAGE_CODE, "${NAME}.violation", args)
      }
      if (!isFirstCharValid(propertyValue)) {
        def args = [constraintPropertyName, constraintOwningClass, propertyValue] as Object[]
        rejectValue(target, errors, DEFAULT_MESSAGE_CODE, "${NAME}.violation", args)
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

    println(NAME + ":ok for value[" + value + "]")
    return true
      
  }
  
  /**
   * is only passed upper case due to Postcode setter
   * @param value
   * @return
   */
  boolean isFirstCharValid(String value) {
    
    if (!checkRegex("[A-Z]", value[0]))
    {
      println("NOT a char")
      return false
    }
    
    println(NAME + ":ok for value[" + value + "]")
    return true
      
  }
  
  private boolean checkRegex(String regex, String input) {
    Pattern pattern = Pattern.compile(regex);
    return (pattern.matcher(input).matches());
   }
  
}
