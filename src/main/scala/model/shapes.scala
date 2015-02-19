package model

/** A common abstraction for graphical shapes. */
sealed trait Shape

/**
 * A decorator for specifying a shape's location.
 * In Scala, this cannot be a case class because we want to inherit from it.
 */
class Location( val x : Int, val y : Int, val child : Shape ) extends Shape {
  require( child != null, "null child in " + getClass.getSimpleName )

  override def equals( o : Any ) = o match {
    case that : Location => this.x == that.x && this.y == that.y && this.child == that.child
    case _ => false
  }
}

/** The companion object that allows us to use this class like a case class. */
object Location {
  def apply( x : Int, y : Int, child : Shape ) = new Location( x, y, child )

  def unapply( l : Location ) = Some( (l.x, l.y, l.child) )
}

/** A rectangle with specified width and height. */
case class Rectangle( width : Int, height : Int ) extends Shape

/** A circle with a specified radius. */
case class Circle( radius : Int ) extends Shape

/** A point, implemented as a location without a shape. */
case class Point( override val x : Int, override val y : Int ) extends Location( x, y, Circle( 0 ) )

class LineSegment( val p1 : Point, val p2 : Point ) extends Shape {
  require( p1 != p2, "points are equal in " + getClass.getSimpleName )
  require( p1 != null, "p1 null in " + getClass.getSimpleName )
  require( p2 != null, "p2 null in " + getClass.getSimpleName )
}

object LineSegment {

  def apply( p1 : Point, p2 : Point ) = new LineSegment( p1, p2 )

  def unapply( l : LineSegment ) = Some( l.p1, l.p2 )

}

class Polygon( val children : Point* ) extends Shape {
  require( children != null, "null children in " + getClass.getSimpleName )
  require( !children.contains( null ), "null child in " + getClass.getSimpleName )
}

object Polygon {
  def apply( children : Point* ) = new Polygon( children : _* )

  def unapply( p : Polygon ) = Some( p.children )
}