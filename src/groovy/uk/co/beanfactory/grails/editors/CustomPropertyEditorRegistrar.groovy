package uk.co.beanfactory.grails.editors

import org.springframework.beans.PropertyEditorRegistrar
import org.springframework.beans.PropertyEditorRegistry

import uk.co.assetmap.location.Postcode

class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar
{
  
 public void registerCustomEditors(PropertyEditorRegistry registry) {
     registry.registerCustomEditor(Postcode.class, new PostcodePropertyEditor());
 }
}
