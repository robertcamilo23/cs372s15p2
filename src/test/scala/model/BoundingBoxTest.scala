package model

import org.scalatest.{FlatSpec, ShouldMatchers}

class BoundingBoxTest extends FlatSpec with ShouldMatchers {

  import model.fixtures._

  "The bounding box behavior" should "work for a simple circle" in {
    boundingBox( simpleCircle ) should equal( Location( -50, -50, Rectangle( 100, 100 ) ) )
  }
  it should "work for a simple rectangle" in {
    boundingBox( simpleRectangle ) should equal( Location( 0, 0, Rectangle( 80, 120 ) ) )
  }
  it should "work for a simple polygon" in {
    boundingBox( simplePolygon ) should equal( Location( 50, 50, Rectangle( 70, 60 ) ) )
  }
  it should "work for a simple location" in {
    boundingBox( simpleLocation ) should equal( Location( 70, 30, Rectangle( 80, 120 ) ) )
  }
  it should "work for a simple line segment" in {
    boundingBox( simpleLineSegment ) should equal( Location( -3, -3, Rectangle( 3, 1 ) ) )
  }
}