package model

import org.scalatest.{ FlatSpec, ShouldMatchers }

/**
 * Created by robert on 2/23/15.
 */
class LineSegmentTest extends FlatSpec with ShouldMatchers {

  import model.lineSegmentFixtures._

  "The horizontal upper line segment" should "intersect with the diagonal up left line segment" in {
    horizontalUpLineSegment.intersectsLineSegment( diagonalUpLeftLineSegment ) should equal( true )
  }
  it should "intersect with the diagonal down right line segment" in {
    horizontalUpLineSegment.intersectsLineSegment( diagonalDownRightLineSegment ) should equal( true )
  }
  it should " not intersect with the diagonal down left line segment" in {
    horizontalUpLineSegment.intersectsLineSegment( diagonalDownLeftLineSegment ) should equal( false )
  }
  it should " not intersect with the diagonal up right line segment" in {
    horizontalUpLineSegment.intersectsLineSegment( diagonalUpRightLineSegment ) should equal( false )
  }
  it should " not intersect with the horizontal down line segment" in {
    horizontalUpLineSegment.intersectsLineSegment( horizontalDownLineSegment ) should equal( false )
  }
  it should " not intersect with the vertical left line segment" in {
    horizontalUpLineSegment.intersectsLineSegment( verticalLeftLineSegment ) should equal( false )
  }
  it should " not intersect with the vertical right line segment" in {
    horizontalUpLineSegment.intersectsLineSegment( verticalRightLineSegment ) should equal( false )
  }

  "The horizontal down line segment" should "not intersect with the diagonal up left line segment" in {
    horizontalDownLineSegment.intersectsLineSegment( diagonalUpLeftLineSegment ) should equal( false )
  }
  it should "not intersect with the diagonal down right line segment" in {
    horizontalDownLineSegment.intersectsLineSegment( diagonalDownRightLineSegment ) should equal( false )
  }
  it should " intersect with the diagonal down left line segment" in {
    horizontalDownLineSegment.intersectsLineSegment( diagonalDownLeftLineSegment ) should equal( true )
  }
  it should " intersect with the diagonal up right line segment" in {
    horizontalDownLineSegment.intersectsLineSegment( diagonalUpRightLineSegment ) should equal( true )
  }
  it should " not intersect with the horizontal upper line segment" in {
    horizontalDownLineSegment.intersectsLineSegment( horizontalUpLineSegment ) should equal( false )
  }
  it should " not intersect with the vertical left line segment" in {
    horizontalDownLineSegment.intersectsLineSegment( verticalLeftLineSegment ) should equal( false )
  }
  it should " not intersect with the vertical right line segment" in {
    horizontalDownLineSegment.intersectsLineSegment( verticalRightLineSegment ) should equal( false )
  }

  "The vertical left line segment" should " intersect with the diagonal up left line segment" in {
    verticalLeftLineSegment.intersectsLineSegment( diagonalUpLeftLineSegment ) should equal( true )
  }
  it should "not intersect with the diagonal down right line segment" in {
    verticalLeftLineSegment.intersectsLineSegment( diagonalDownRightLineSegment ) should equal( false )
  }
  it should " intersect with the diagonal down left line segment" in {
    verticalLeftLineSegment.intersectsLineSegment( diagonalDownLeftLineSegment ) should equal( true )
  }
  it should "not intersect with the diagonal up right line segment" in {
    verticalLeftLineSegment.intersectsLineSegment( diagonalUpRightLineSegment ) should equal( false )
  }
  it should " intersect with the horizontal down line segment" in {
    verticalLeftLineSegment.intersectsLineSegment( horizontalDownLineSegment ) should equal( true )
  }
  it should " intersect with the horizontal upper line segment" in {
    verticalLeftLineSegment.intersectsLineSegment( horizontalUpLineSegment ) should equal( true )
  }
  it should " not intersect with the vertical right line segment" in {
    verticalLeftLineSegment.intersectsLineSegment( verticalRightLineSegment ) should equal( false )
  }

  "The vertical right line segment" should "not intersect with the diagonal up left line segment" in {
    verticalRightLineSegment.intersectsLineSegment( diagonalUpLeftLineSegment ) should equal( false )
  }
  it should "intersect with the diagonal down right line segment" in {
    verticalRightLineSegment.intersectsLineSegment( diagonalDownRightLineSegment ) should equal( true )
  }
  it should "not intersect with the diagonal down left line segment" in {
    verticalRightLineSegment.intersectsLineSegment( diagonalDownLeftLineSegment ) should equal( false )
  }
  it should " intersect with the diagonal up right line segment" in {
    verticalRightLineSegment.intersectsLineSegment( diagonalUpRightLineSegment ) should equal( true )
  }
  it should " intersect with the horizontal down line segment" in {
    verticalRightLineSegment.intersectsLineSegment( horizontalDownLineSegment ) should equal( true )
  }
  it should " intersect with the horizontal upper line segment" in {
    verticalRightLineSegment.intersectsLineSegment( horizontalUpLineSegment ) should equal( true )
  }
  it should " not intersect with the vertical left line segment" in {
    verticalRightLineSegment.intersectsLineSegment( verticalLeftLineSegment ) should equal( false )
  }
}