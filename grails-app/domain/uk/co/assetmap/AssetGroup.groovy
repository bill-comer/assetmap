package uk.co.assetmap

class AssetGroup {

  static hasMany = [asset:Asset]
  
  String name
  String description
  Date created
  
    static constraints = {
      name(blank: false)
    }
}
