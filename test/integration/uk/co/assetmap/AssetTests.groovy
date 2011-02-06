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
            
      assertTrue(asset.validate())
    }
    
    void testNameBlank() {
      AssetGroup assetGroup = new AssetGroup(name:"testGroup");
      Asset asset = new Asset(assetGroup:assetGroup)
      
      assertFalse(asset.validate())
      assertTrue(asset.errors.hasFieldErrors("name"))
    }
    
    void testNameTooShort() {
      AssetGroup assetGroup = new AssetGroup(name:"testGroup");
      Asset asset = new Asset(name:"fail", assetGroup:assetGroup)
        
      assertFalse(asset.validate())
      assertTrue(asset.errors.hasFieldErrors("name"))
    }
}
