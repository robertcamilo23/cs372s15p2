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
    case Group( shapes ) =>
      val locationValues = locationValuesOfGroup( shapes )
      Location( locationValues._1, locationValues._2, Rectangle( locationValues._3, locationValues._4 ) )
    case Polygon( points ) =>
      apply( Group( points ) )
    case LineSegment( p1, p2 ) =>
      apply( Group( p1, p2 ) )
    case Ray( p1, p2 ) =>
      apply( LineSegment( p1, p2 ) )
    case Location( x, y, shape ) =>
      val shapeLoc = apply( shape )
      Location( x + shapeLoc.x, y + shapeLoc.y, shape )
    case _ =>
      Location( 0, 0, Rectangle( 0, 0 ) )
  }

  def locationValuesOfGroup( shapes : Seq[ Shape ] ) : (Double, Double, Double, Double) = {

    def minMaxXY( points : Seq[ Point ] ) : (Double, Double, Double, Double) = {
      val minMaxXYVal = points.foldLeft( (points.head.x, points.head.y, points.head.x, points.head.y) )( ( r, c ) =>
        (math.min( r._1, c.x ), math.min( r._2, c.y ), math.max( r._3, c.x ), math.max( r._4, c.y )) )
      (minMaxXYVal._1, minMaxXYVal._2, ( minMaxXYVal._3 - minMaxXYVal._1 ), ( minMaxXYVal._4 - minMaxXYVal._2 ))
    }

    shapes.head match {
      case point : Point => {
        shapes match {
          case points : Seq[ Point ] => minMaxXY( points )
        }
      }
      case polygon : Polygon => {
        shapes match {
          case polygons : Seq[ Polygon ] => minMaxXY( polygons.foldLeft( polygons.head.children )( ( r, c ) => r ++ c.children ) )
        }
      }
      case _ => (0, 0, 0, 0)
    }
  }
}