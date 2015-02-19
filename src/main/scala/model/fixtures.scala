package model

object fixtures {

  val simpleCircle = Circle( 50 )

  val simpleRectangle = Rectangle( 80, 120 )

  val simplePolygon = Polygon( Point( 50, 50 ), Point( 60, 100 ), Point( 100, 110 ), Point( 120, 60 ) )

  val simpleLocation = Location( 70, 30, Rectangle( 80, 120 ) )

  val simpleLineSegment = LineSegment( Point( -3, -3 ), Point( 0, -4 ) )

}