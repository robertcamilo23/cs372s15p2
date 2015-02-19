package model

import org.scalatest.{FlatSpec, ShouldMatchers}

class SizeTest extends FlatSpec with ShouldMatchers {

  import model.fixtures._
  import model.{size => ssize}

  // to avoid weird naming conflict

  "The size behavior" should "work for a simple circle" in {
    ssize( simpleCircle ) should equal( 1 )
  }
  it should "work for a simple rectangle" in {
    ssize( simpleRectangle ) should equal( 1 )
  }
  it should "work for a simple polygon" in {
    ssize( simplePolygon ) should equal( 1 )
  }
  it should "work for a simple location" in {
    ssize( simpleLocation ) should equal( 1 )
  }
}