package uk.co.beanfactory.grails.validation


import grails.test.*

class PostcodeOutwardConstraintTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testisLengthValid_nullString() {
      PostcodeOutwardConstraint sut = new PostcodeOutwardConstraint()
      assertFalse(sut.isLengthValid(null));
    }
    
    void testisLengthValid_emptyString() {
      PostcodeOutwardConstraint sut = new PostcodeOutwardConstraint()
      assertFalse(sut.isLengthValid(""));
    }
    
    void testisLengthValid_shortString() {
      PostcodeOutwardConstraint sut = new PostcodeOutwardConstraint()
      assertFalse(sut.isLengthValid("q"));
    }
    
    void testisLengthValid_longString() {
      PostcodeOutwardConstraint sut = new PostcodeOutwardConstraint()
      assertFalse(sut.isLengthValid("qwert"));
    }
    
    void testisLengthValid_okString_2chars() {
      PostcodeOutwardConstraint sut = new PostcodeOutwardConstraint()
      assertTrue(sut.isLengthValid("b1"));
    }
    
    void testisLengthValid_okString_3chars() {
      PostcodeOutwardConstraint sut = new PostcodeOutwardConstraint()
      assertTrue(sut.isLengthValid("bl7"));
    }
    
    void testisLengthValid_okString_4chars() {
      PostcodeOutwardConstraint sut = new PostcodeOutwardConstraint()
      assertTrue(sut.isLengthValid("bl72"));
    }
    
    void testisFirstCharValid_invalidNumber() {
      PostcodeOutwardConstraint sut = new PostcodeOutwardConstraint()
      assertFalse(sut.isFirstCharValid("1"));
    }
    
    void testisFirstCharValid_invalidPunctuation() {
      PostcodeOutwardConstraint sut = new PostcodeOutwardConstraint()
      assertFalse(sut.isFirstCharValid(":"));
    }
    
    void testisFirstCharValid_validUpperChar() {
      PostcodeOutwardConstraint sut = new PostcodeOutwardConstraint()
      assertTrue(sut.isFirstCharValid("A"));
    }
    
    void testcheckTwoCharOutward_secondCharIsChar() {
      PostcodeOutwardConstraint sut = new PostcodeOutwardConstraint()
      assertFalse(sut.checkTwoCharOutward("AA"));
    }
    
    void testcheckTwoCharOutward_secondCharIsPunctuation() {
      PostcodeOutwardConstraint sut = new PostcodeOutwardConstraint()
      assertFalse(sut.checkTwoCharOutward("A:"));
    }
    
    void testcheckTwoCharOutward_secondCharIsNumber() {
      PostcodeOutwardConstraint sut = new PostcodeOutwardConstraint()
      assertTrue(sut.checkTwoCharOutward("A0"));
      assertTrue(sut.checkTwoCharOutward("A1"));
      assertTrue(sut.checkTwoCharOutward("A2"));
      assertTrue(sut.checkTwoCharOutward("A3"));
      assertTrue(sut.checkTwoCharOutward("A4"));
      assertTrue(sut.checkTwoCharOutward("A5"));
      assertTrue(sut.checkTwoCharOutward("A6"));
      assertTrue(sut.checkTwoCharOutward("A7"));
      assertTrue(sut.checkTwoCharOutward("A8"));
      assertTrue(sut.checkTwoCharOutward("A9"));
    }
}
