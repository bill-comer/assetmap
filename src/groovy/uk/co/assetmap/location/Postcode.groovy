package uk.co.assetmap.location

class Postcode
{
  String outward
  String inward
  
  static constraints = {
    outward(blank: false, maxSize:4)
    inward(blank: false, maxSize:3)
  }
  
}
