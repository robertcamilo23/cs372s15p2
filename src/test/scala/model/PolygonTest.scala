package model

import org.scalatest.{ FlatSpec, ShouldMatchers }

/**
 * Created by robert on 2/23/15.
 */
class PolygonTest extends FlatSpec with ShouldMatchers {

  import model.polygonFixtures._

  "The polygon area" should "work for a square polygon" in {
    square.getArea should equal( 4 )
  }
  it should "work for a trapezoid polygon" in {
    //Exact area = 6.0
    val trapezoidArea = trapezoid.getArea
    assert( 5.9 <= trapezoidArea && trapezoidArea <= 6.1 )
  }
  it should "work for a concave polygon" in {
    //Exact area = 8.5
    val concaveArea = concave.getArea
    assert( 8.4 <= concaveArea && concaveArea <= 8.6 )
  }
  it should "work for a convex location" in {
    //Exact area = 24
    val convexArea = convex.getArea
    assert( 23.9 <= convexArea && convexArea <= 24.1 )
  }
}