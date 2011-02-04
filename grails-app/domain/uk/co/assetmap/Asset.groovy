package uk.co.assetmap

class Asset {

  String name
  String description
  String postcode
  
  AssetGroup assetGroup
  
    static constraints = {
      name(blank: false, maxSize:100)
      postcode(maxSize:6)
      description(maxSize:1000)
    }
}
