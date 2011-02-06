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
      AssetGroup assetGroup = new AssetGroup(name:"testGroup");
      
      Asset asset = new Asset(name:"anOkName", assetGroup:assetGroup)
      //asset.assetGroup = assetGroup
      
      if(!asset.validate()) {
        asset.errors.allErrors.each {
          println it
          }
        }
      assertTrue(asset.validate())
    }
    
    void testNameBlank() {
      Asset asset = new Asset()
      assertFalse(asset.validate())
    }
    
    void testNameTooShort() {
      Asset asset = new Asset(name:"fail")
        assertFalse(asset.validate())
    }
}
