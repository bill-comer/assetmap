package uk.co.assetmap

class AssetGroup {

  static hasMany = [asset:Asset]
  
  String name
  String description
  Date created
  
  String toString(){
    return name
  }
  
    static constraints = {
      name(blank: false, maxSize:100)
      description(maxSize:1000)
    }
}
