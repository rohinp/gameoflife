package com.eqe.gol

import org.junit.Test
import org.scalatest.Matchers._

class CellTests {

  @Test
  def itShouldCreateALivingCellWithGivenPosition(): Unit ={
    //given
    val p:Coordinate = Coordinate(1,2)
    val c:Cell = Cell(p,isAlive = true)

    //when

    //then
    c shouldEqual AliveCell(p)
    c.coordinate shouldEqual Coordinate(1,2)
  }

  @Test
  def itShouldCreateADeadCellWithGivenPosition(): Unit ={
    //given
    val p:Coordinate = Coordinate(1,2)
    val c:Cell = Cell(p,isAlive = false)

    //when

    //then
    c shouldEqual DeadCell(p)
    c.coordinate shouldEqual Coordinate(1,2)
  }

  @Test
  def itShouldMakeADeadCellAlive(): Unit = {
    //given
    val p:Coordinate = Coordinate(1,2)
    val c:Cell = Cell(p,isAlive = false)

    //when
    val actual = c.toggleLife()

    //then
    actual shouldEqual AliveCell(p)
  }

  @Test
  def itShouldMakeAliveCellDead(): Unit = {
    //given
    val p:Coordinate = Coordinate(1,2)
    val c:Cell = Cell(p,isAlive = true)

    //when
    val actual = c.toggleLife()

    //then
    actual shouldEqual DeadCell(p)
  }
}
