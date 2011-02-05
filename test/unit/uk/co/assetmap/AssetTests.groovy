package uk.co.assetmap

import grails.test.*

class AssetTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testNameOK() {
      Asset asset = new Asset(name:"anOkName")
    }
    
    void testNameBlank() {
      Asset asset = new Asset()
      try {
        asset.validate()
        fail("should have thrown validation Exception")
      }
      catch (Exception e){
      }
    }
    void testNameTooShort() {
      Asset asset = new Asset(name:"fail")
      try {
        asset.validate()
        fail("should have thrown validation Exception name too short")
      }
      catch (Exception e){
      }
    }
}
