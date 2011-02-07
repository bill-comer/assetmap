package uk.co.beanfactory.grails.validation


import uk.co.beanfactory.grails.validation.PostcodeInwardConstraint;
import grails.test.*

class PostcodeInwardConstraintTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testLength() {
      PostcodeInwardConstraint sut = new PostcodeInwardConstraint()
      assertFalse(sut.isLengthThreeChars(null))
      assertFalse(sut.isLengthThreeChars(""))
      assertFalse(sut.isLengthThreeChars("a"))
      assertFalse(sut.isLengthThreeChars("aa"))
      assertFalse(sut.isLengthThreeChars("aaaa"))
      
      assertTrue(sut.isLengthThreeChars("aaa"))

    }
}
