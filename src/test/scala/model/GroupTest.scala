package model

import org.scalatest._

/**
 * Created by robert on 2/25/15.
 */
class GroupTest extends FlatSpec with ShouldMatchers {

  import model.groupFixtures._

  "The group area" should "work for a simple group" in {
    val group1Area = group1.getArea
    assert( 2805.4 <= group1Area && group1Area <= 2805.6 )
  }
}