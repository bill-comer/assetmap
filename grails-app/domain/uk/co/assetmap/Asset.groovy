package uk.co.assetmap

class Asset {

  String name
  String description
  
  AssetGroup assetGroup
  
    static constraints = {
      name(blank: false)
    }
}
