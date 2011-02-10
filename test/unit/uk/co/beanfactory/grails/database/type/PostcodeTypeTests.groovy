package uk.co.beanfactory.grails.database.type;

import static org.junit.Assert.*

import java.util.ArrayList

import uk.co.assetmap.location.Postcode

import com.mockrunner.jdbc.BasicJDBCTestCaseAdapter
import com.mockrunner.mock.jdbc.MockConnection
import com.mockrunner.mock.jdbc.MockPreparedStatement
import com.mockrunner.mock.jdbc.MockResultSet

class PostcodeTypeTests extends BasicJDBCTestCaseAdapter
{
  void testNullSafeGet()
  {
    PostcodeType postcodeType = new PostcodeType()

    MockResultSet resultSet = new MockResultSet("testMock")

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

  void testNullSafeSet()
  {
    PostcodeType postcodeType = new PostcodeType()

    Postcode postcode = new Postcode(outward:"BL7", inward:"0NG")
    MockConnection mockConnection =
            getJDBCMockObjectFactory().getMockConnection();
    MockPreparedStatement mockPreparedStatement = new MockPreparedStatement(mockConnection, "")

    //test method
    postcodeType.nullSafeSet (mockPreparedStatement, postcode, 1)
    
    assertEquals("BL7 0NG", mockPreparedStatement.getParameter(1) )

  }
}
