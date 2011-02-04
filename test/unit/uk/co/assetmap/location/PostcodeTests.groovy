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
      assertEquals "BL7 0NG", "" + pc.toString()
    }
    
    void testAValidEntwistlePCLowerCase(){
      Postcode pc = new Postcode(outward:"bl7", inward:"0ng")
      assertEquals "BL7 0NG", "" + pc.toString()
    }
    
  }

