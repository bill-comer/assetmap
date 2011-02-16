package uk.co.beanfactory.grails.editors

import java.beans.PropertyEditor
import java.beans.PropertyEditorSupport

import org.apache.commons.el.parser.ParseException

import uk.co.assetmap.location.Postcode


class PostcodePropertyEditor extends PropertyEditorSupport implements PropertyEditor {
  
   
  /**
   * Converts text postcode to a Postcode object.
   * @param aText text version of date
   */
  public void setAsText(String postcodeAsText)
  {
    String[] data = postcodeAsText.split(",")
    
    if (data.length != 2) {
      throw new ParseException("Postcode has errors: Must be two items comma separated")
    }

    Postcode postcode = null
    try
    {
      postcode = new Postcode(outward:data[0], inward:data[1])
      if (!postcode.validate()) {
        throw new ParseException("Postcode has errors:" + postcode.errors.allErrors)
      }
      
      setValue(postcode)
    }
    catch (ParseException e)
    {
      e.printStackTrace()
      throw e
    }

   
  }
  
   
  /**
   * @return Text version of date
   */
  public String getAsText()
  {
    String text = null;
    if (getValue() instanceof Postcode)
    {
      Postcode postcode = (Postcode) getValue();
      text = postcode.toString()
    }
    
    if (text != null)
    {
      return text;
    }
    return new String();
  }

}
