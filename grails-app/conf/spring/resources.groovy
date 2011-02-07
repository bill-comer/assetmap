import org.codehaus.groovy.grails.validation.ConstrainedProperty

import uk.co.beanfactory.grails.validation.PostcodeInwardConstraint
import uk.co.beanfactory.grails.validation.PostcodeOutwardConstraint

// Place your Spring DSL code here
beans = {
  ConstrainedProperty.registerNewConstraint(PostcodeOutwardConstraint.NAME, PostcodeOutwardConstraint)
  ConstrainedProperty.registerNewConstraint(PostcodeInwardConstraint.NAME, PostcodeInwardConstraint)
}
