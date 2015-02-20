package model

/** A common abstraction for graphical shapes. */
sealed trait Shape

/**
 * A decorator for specifying a shape's location.
 * In Scala, this cannot be a case class because we want to inherit from it.
 */
class Location( val x : Double, val y : Double, val child : Shape ) extends Shape {
  require( child != null, "null child in " + getClass.getSimpleName )

  override def equals( o : Any ) = o match {
    case that : Location => this.x == that.x && this.y == that.y && this.child == that.child
    case _ => false
  }
}

/** The companion object that allows us to use this class like a case class. */
object Location {
  def apply( x : Double, y : Double, child : Shape ) = new Location( x, y, child )

  def unapply( l : Location ) = Some( (l.x, l.y, l.child) )
}

/** A rectangle with specified width and height. */
case class Rectangle( width : Double, height : Double ) extends Shape

/** A circle with a specified radius. */
case class Circle( radius : Int ) extends Shape

/** A point, implemented as a location without a shape. */
case class Point( override val x : Double, override val y : Double ) extends Location( x, y, Circle( 0 ) )

class LineSegment( val p1 : Point, val p2 : Point ) extends Shape {
  require( p1 != p2, "points are equal in " + getClass.getSimpleName )
  require( p1 != null, "p1 null in " + getClass.getSimpleName )
  require( p2 != null, "p2 null in " + getClass.getSimpleName )

  def intersectsLineSegment( lineSegment : LineSegment ) : Boolean = {

    val as = (( this.p2.y - this.p1.y ) / ( this.p2.x - this.p1.x ), ( lineSegment.p2.y - lineSegment.p1.y ) / ( lineSegment.p2.x - lineSegment.p1.x ))
    if( as._1 == as._2 ) return false

    val bs = (this.p1.y - ( this.p1.x * as._1 ), lineSegment.p1.y - ( lineSegment.p1.x * as._2 ))
    val xIntersection = ( bs._2 - bs._1 ) / ( as._1 - as._2 )
    val yIntersection = as._1 * xIntersection + bs._1

    if( lineSegment.p1.x < xIntersection && xIntersection < lineSegment.p2.x ) {
      if( this.p1.y > this.p2.y ) this.p1.y >= yIntersection && this.p2.y <= yIntersection
      else this.p2.y >= yIntersection && this.p1.y <= yIntersection
    } else false
  }
}

object LineSegment {

  def apply( p1 : Point, p2 : Point ) = new LineSegment( p1, p2 )

  def unapply( l : LineSegment ) = Some( l.p1, l.p2 )

}

case class Ray( override val p1 : Point, override val p2 : Point ) extends LineSegment( p1, p2 )

class Group( val children : Point* ) extends Shape {
  require( children != null, "null children in " + getClass.getSimpleName )
  require( !children.contains( null ), "null child in " + getClass.getSimpleName )
}

/** The companion object that allows us to use this class like a case class. */
object Group {
  def apply( children : Point* ) = new Group( children : _* )

  def unapply( g : Group ) = Some( g.children )
}

/** A special case of a group consisting only of Points. */
case class Polygon( override val children : Point* ) extends Group( children : _* ) {

  def getLineSegments : List[ LineSegment ] = {
    val pairPoints = this.children.sliding( 2 ).toList
    return pairPoints.foldLeft( List( LineSegment( this.children.head, this.children.last ) ) )( ( r, c ) => r :+ ( LineSegment( c.head, c.last ) ) )
  }
  
}