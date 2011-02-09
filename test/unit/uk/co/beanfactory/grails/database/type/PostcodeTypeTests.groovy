package uk.co.beanfactory.grails.database.type;

import static org.junit.Assert.*

import java.sql.ResultSet;
import java.util.ArrayList;

import uk.co.assetmap.location.Postcode

import com.mockrunner.mock.jdbc.MockResultSet

class PostcodeTypeTests
{
  void testnullSafeGet() {
    PostcodeType postcodeType = new PostcodeType();
    MockResultSet resultSet = new MockResultSet()
    resultSet.setResultSetType(Types.VARCHAR)
    String[] names = "postcode"
    ArrayList<String> mockresultData = new ArrayList<String>()
    mockResultData.add("BL7 0NG")
    resultSet.addColumn(names[0], mockResultData)
    
    Object owner = null;
    
    Postcode createdPostcode = postcodeType.nullSafeGet (resultSet, names, owner)
  }
}
