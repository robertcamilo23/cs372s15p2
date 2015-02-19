package model

/**
 * A shape visitor for calculating the bounding box, that is, the smallest
 * rectangle containing the shape. The resulting bounding box is returned as a
 * rectangle at a specific location.
 */
object boundingBox {

  def apply( s : Shape ) : Location = s match {
    case Circle( radius ) =>
      Location( -radius, -radius, Rectangle( 2 * radius, 2 * radius ) )
    case Rectangle( width, height ) =>
      Location( 0, 0, Rectangle( width, height ) )
    case Polygon( points ) =>
      Location( minX( points ), minY( points ), Rectangle( groupWidth( points ), groupHeight( points ) ) )
    case LineSegment( p1, p2 ) =>
      Location( minX( Seq( p1, p2 ) ), maxY( Seq( p1, p2 ) ), Rectangle( groupWidth( Seq( p1, p2 ) ), groupHeight( Seq( p1, p2 ) ) ) )
    case Location( x, y, shape ) =>
      Location( x, y, shape )
    case _ =>
      Location( 0, 0, Rectangle( 0, 0 ) )
  }

  def minX( points : Seq[Point] ) : Int = {

    def minXImpl( points : Seq[Point], minX : Int ) : Int = {
      if ( points.isEmpty ) minX
      else minXImpl( points.tail, math.min( minX, points.head.x ) )
    }

    minXImpl( points, points.head.x )
  }

  def maxX( points : Seq[Point] ) : Int = {

    def maxXImpl( points : Seq[Point], maxX : Int ) : Int = {
      if ( points.isEmpty ) maxX
      else maxXImpl( points.tail, math.max( maxX, points.head.x ) )
    }

    maxXImpl( points, points.head.x )
  }

  def maxY( points : Seq[Point] ) : Int = {

    def maxYImpl( points : Seq[Point], maxY : Int ) : Int = {
      if ( points.isEmpty ) maxY
      else maxYImpl( points.tail, math.max( maxY, points.head.y ) )
    }

    maxYImpl( points, points.head.y )
  }

  def minY( points : Seq[Point] ) : Int = {

    def minYImpl( points : Seq[Point], minY : Int ) : Int = {
      if ( points.isEmpty ) minY
      else minYImpl( points.tail, math.min( minY, points.head.y ) )
    }

    minYImpl( points, points.head.y )
  }

  def groupWidth( points : Seq[Point] ) : Int = maxX( points ) - minX( points )

  def groupHeight( points : Seq[Point] ) : Int = maxY( points ) - minY( points )
}