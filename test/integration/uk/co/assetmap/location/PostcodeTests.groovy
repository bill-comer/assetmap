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
    
    
    void testAnInValidEntwistle_inwardTooLong(){
      Postcode pc = new Postcode(outward:"bl7", inward:"0ngasdasda")
      assertFalse(pc.validate())
    }
    
  }

