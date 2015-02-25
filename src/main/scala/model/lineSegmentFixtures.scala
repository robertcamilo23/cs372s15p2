package model

/**
 * Created by robert on 2/23/15.
 */
object lineSegmentFixtures {

  val horizontalUpLineSegment = LineSegment( Point( -4, 4 ), Point( 4, 4 ) )

  val horizontalDownLineSegment = LineSegment( Point( -4, -4 ), Point( 4, -4 ) )

  val verticalLeftLineSegment = LineSegment( Point( -4, -4 ), Point( -4, 4 ) )

  val verticalRightLineSegment = LineSegment( Point( 4, -4 ), Point( 4, 4 ) )

  val diagonalUpLeftLineSegment = LineSegment( Point( -7, -3 ), Point( 3, 7 ) )

  val diagonalUpRightLineSegment = LineSegment( Point( -3, -7 ), Point( 7, 3 ) )

  val diagonalDownRightLineSegment = LineSegment( Point( -3, 7 ), Point( 7, -3 ) )

  val diagonalDownLeftLineSegment = LineSegment( Point( -7, 3 ), Point( 3, -7 ) )

}