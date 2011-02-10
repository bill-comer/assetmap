package uk.co.assetmap

import uk.co.assetmap.location.Postcode
import uk.co.beanfactory.grails.database.type.PostcodeType

class Asset
{

  String name
  String description
  Postcode postcode

  AssetGroup assetGroup

  static constraints =
  {
    name(blank: false, size:5..100)
    postcode(nullable:true)
    description(maxSize:1000, nullable:true)
  }
  
  static mapping = {
    postcode type: PostcodeType, {column name: "postcode" }
    }
}
