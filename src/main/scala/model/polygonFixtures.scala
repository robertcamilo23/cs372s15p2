package model

/**
 * Created by robert on 2/23/15.
 */
object polygonFixtures {

  val square = Polygon( Point( 0, 0 ), Point( 0, 2 ), Point( 2, 2 ), Point( 2, 0 ) )

  val trapezoid = Polygon( Point( -2, 0 ), Point( -1, 2 ), Point( 1, 2 ), Point( 2, 0 ) )

  val concave = Polygon( Point( -2, 0 ), Point( -1, 3 ), Point( 0, 1 ), Point( 1, 3 ), Point( 2, -1 ) )

  val convex = Polygon( Point( -3, 0 ), Point( 0, 3 ), Point( 3, 0 ), Point( 2, -3 ), Point( -2, -3 ) )

}