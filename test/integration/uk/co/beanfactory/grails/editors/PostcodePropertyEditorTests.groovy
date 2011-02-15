package uk.co.beanfactory.grails.editors;

import static org.junit.Assert.*

import org.apache.commons.el.parser.ParseException;

import grails.test.GrailsUnitTestCase
import uk.co.assetmap.location.Postcode

class PostcodePropertyEditorTests extends GrailsUnitTestCase
{

  void testSetAsText_OKdata() {
    PostcodePropertyEditor editor = new PostcodePropertyEditor()
    String[] testData = ["BL7", "0NG"]
    
    //test method
    editor.setAsText(testData)
    
    Postcode createdPostcode = (Postcode)editor.getValue()
    assertNotNull createdPostcode
    assertEquals("BL7", createdPostcode.getOutward())
    assertEquals("0NG", createdPostcode.getInward())
  }
  
  void testSetAsText_InvalidData() {
    PostcodePropertyEditor editor = new PostcodePropertyEditor()
    String[] testData = ["BL7"]
    
    //test method
    try {
      editor.setAsText(testData)
      fail "Should have thrown parse Exception"
    } catch (ParseException e) {
    
    }
  }
  
  
  void testSetAsText_InvalidPostcode() {
    PostcodePropertyEditor editor = new PostcodePropertyEditor()
    String[] testData = ["BL7", "dgajdgasjhd"]
    
    //test method
    try {
      editor.setAsText(testData)
      fail "Should have thrown parse Exception"
    } catch (ParseException e) {
    
    }
  }
  
  void testGetAsText() {
    PostcodePropertyEditor editor = new PostcodePropertyEditor()
    Postcode postcode = new Postcode(outward:"BL7", inward:"0NG")
    editor.setValue postcode
    
    assertEquals("BL7 0NG", editor.getAsText())
  }
}
