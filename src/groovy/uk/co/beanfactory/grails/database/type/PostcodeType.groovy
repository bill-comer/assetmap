package uk.co.beanfactory.grails.database.type

import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Types

import org.hibernate.HibernateException
import org.hibernate.usertype.UserType
import org.springframework.util.Assert;

import uk.co.assetmap.location.Postcode


class PostcodeType implements UserType
{

  private static final SQL_TYPES = [Types.VARCHAR]as int[]

  public int[] sqlTypes()
  {
    SQL_TYPES
  }

  public Class returnedClass()
  {
    PostcodeType
  }

  public boolean equals(x, y)
  {
    x == y
  }

  public int hashCode(x)
  {
    if (x == null)
    {
      return -1;
    }
    x.hashCode()
  }

  public Object deepCopy(value)
  {
    value
  }

  public boolean isMutable()
  {
    false
  }

  Serializable disassemble(value)
  {
    value
  }

  def assemble(Serializable cached, owner)
  {
    cached
  }

  def replace(original, target, owner)
  {
    original
  }

  def Object nullSafeGet(ResultSet resultSet, String[] names, Object owner) throws HibernateException, SQLException
  {
    if (resultSet == null) {
      return null;
    }
    
    //get outward and inward
    String[] values = resultSet.getString(names[0]).split(" ");
    Assert.isTrue(values.length == 2, "MUST be two parts to the Postcode split by a space")
    Postcode postcode = new Postcode(outward:values[0], inward:values[1]);
    
    return postcode
  }

  void nullSafeSet(PreparedStatement statement, Object value, int index)
  {
    if (value == null)
    {
      statement.setString(index, null)
    } else
    {
      Postcode postcode = value
      statement.setString(index, postcode.getOutward() + " " + postcode.getInward())
    }
  }
}
