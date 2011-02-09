package uk.co.beanfactory.grails.database.type;

import static org.junit.Assert.*

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import uk.co.assetmap.location.Postcode

import com.mockrunner.mock.jdbc.MockResultSet

class PostcodeTypeTests
{
  void testNullSafeGet() {
    PostcodeType postcodeType = new PostcodeType()
	
    MockResultSet resultSet = new MockResultSet("testMock")
	
    //resultSet.setResultSetType(Types.VARCHAR)
    String[] names = "postcode"
    
	ArrayList<String> mockResultData = new ArrayList<String>()
    mockResultData.add("BL7 0NG")
    resultSet.addColumn(names[0], mockResultData)
	resultSet.next()
    
    Object owner = null;
    
	//test method
    Postcode createdPostcode = postcodeType.nullSafeGet (resultSet, names, owner)
	
	assertEquals ("BL7", createdPostcode.getOutward())
	assertEquals ("0NG", createdPostcode.getInward())
  }
  
  void testNullSafeSet() {
	  PostcodeType postcodeType = new PostcodeType()
	  
	  Postcode postcode = new Postcode(outward:"BL7", inward:"0NG")
	  
	  //test method
	  postcodeType.nullSafeSet (statement, value, 1)
	  
  }
}
