package uk.co.assetmap.location


import com.sun.corba.se.impl.io.OutputStreamHook.InWriteObjectState;

import grails.test.*

class PostcodeTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testAValidEntwistlePC(){
      Postcode pc = new Postcode(outward:"BL7", inward:"0NG")
      if(!pc.validate()) {
        pc.errors.each {
              println "oops-" + it
        }
    }
      assertTrue(pc.validate())
      assertEquals "BL7 0NG", "" + pc.toString()
    }
    
    void testAValidEntwistlePCLowerCase(){
      Postcode pc = new Postcode(outward:"bl7", inward:"0ng")
      assertTrue(pc.validate())
      assertEquals "BL7 0NG", "" + pc.toString()
    }
    
    void testAnInValidEntwistle_outwardTooLong(){
      Postcode pc = new Postcode(outward:"fsdfsfsfs", inward:"0ng")
      assertFalse(pc.validate())
    }
    
    
    void testAnInValidEntwistle_outwardTooShort(){
      Postcode pc = new Postcode(outward:"b", inward:"0ng")
      assertFalse(pc.validate())
    }
    
    
    void testOutwardFirstCharIsLetter(){
      Postcode pc = new Postcode(outward:"bl7", inward:"0ng")
      if(!pc.validate()) {
        pc.errors.each {
              println "oops-" + it
        }
    }
      assertTrue(pc.validate())
    }
    
    void testOutwardFirstCharIsNotLetter(){
      Postcode pc = new Postcode(outward:"7l7", inward:"0ng")
      assertFalse(pc.validate())
      assertTrue(pc.errors.hasFieldErrors("outward"))
    }
    
    void testAnInValidEntwistle_inwardTooLong(){
      Postcode pc = new Postcode(outward:"bl7", inward:"0ngasdasda")
      assertFalse("inward should have failed as more than three chars", pc.validate())
    }
    
    
    void testAnInValidEntwistle_inwardInvalidFormat(){
      Postcode pc = new Postcode(outward:"bl7", inward:"0n5")
      assertFalse("inward should have failed as invalid last digit", pc.validate())
    }
    
  }

