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
    
    void testFirstChar() {
      PostcodeInwardConstraint sut = new PostcodeInwardConstraint()
      assertFalse(sut.isFirstCharANumber("A"))
      assertFalse(sut.isFirstCharANumber(":"))
      assertTrue(sut.isFirstCharANumber("1"))
    }
    
    void test2ndThirdCharsMustBeLetters() {
      PostcodeInwardConstraint sut = new PostcodeInwardConstraint()
      assertFalse(sut.isSecondThirdLetters("711"))
      assertFalse(sut.isSecondThirdLetters("71q"))
      assertFalse(sut.isSecondThirdLetters("7q1"))
      assertTrue(sut.isSecondThirdLetters("8NG"))
    }
}
