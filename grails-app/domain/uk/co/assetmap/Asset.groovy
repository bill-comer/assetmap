package uk.co.assetmap

class Asset {

  String name
  String description
  String postcode
  
  AssetGroup assetGroup
  
    static constraints = {
      name(blank: false, size:5..100)
      postcode( maxSize:6, nullable:true)
      description(maxSize:1000, nullable:true)
    }
}
