package model

/**
 * Created by robert on 2/19/15.
 */
object Hello extends App {
  print( "Hello\n" )

  val aja = boundingBox( LineSegment( Point( -3, 6 ), Point( 5, 6 ) ) )
  print( aja )
}
