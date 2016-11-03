package com.eqe.gol

case class Coordinate(xco:Int,yco:Int) {
  val neighbours = (-1 to 1).flatMap(x => (-1 to 1).map(y => (xco + x,yco + y)))
                            .filter(e => !e.equals((xco,yco)))
                            .toList
}
