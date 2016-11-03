package com.eqe.gol

import org.junit.Test
import org.scalatest.Matchers._

class CoordinateTest {

  @Test
  def itShouldGiveMeNeighboursForGivenCoordinate(): Unit = {
    //given
    val  co:Coordinate = Coordinate(0,0)

    //when

    //then
    co.neighbours should equal(List((-1,-1), (-1,0), (-1,1), (0,-1), (0,1), (1,-1), (1,0), (1,1)))
  }
}
