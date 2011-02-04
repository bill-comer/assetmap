package uk.co.assetmap.location

class Postcode
{
  String outward
  String inward
  
  void setOutward(String s){
    outward = s?.toUpperCase()
  }
  void setInward(String s){
    inward = s?.toUpperCase()
  }
  
  static constraints = {
    outward(blank: false, maxSize:4)
    inward(blank: false, maxSize:3)
  }
  
  String toString(){
    return outward + " " + inward
  }
  
}
