package model

import scala.language.postfixOps

/** A visitor to compute the number of basic shapes in a (possibly complex) shape. */
object size {

  // TODO entirely your job

  def apply( s : Shape ) : Int = s match {
    case _ => -1
  }
}