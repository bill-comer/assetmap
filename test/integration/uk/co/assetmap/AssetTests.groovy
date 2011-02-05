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
