package uk.co.assetmap.location

import org.codehaus.groovy.grails.validation.Validateable

@Validateable
class Postcode
{
  String outward  // first part
  String inward   // second part
  
  void setOutward(String s){
    outward = s?.toUpperCase()
  }
  void setInward(String s){
    inward = s?.toUpperCase()
  }
  
  static constraints = {
    outward(pc_outward:true)
    inward(blank: false, maxSize:3)
  }
  
  String toString(){
    return outward + " " + inward
  }
  
}
