package com.eqe.gol

import org.junit.Test
import org.scalatest.Matchers._

class BoardTests {

  val cells = List(
    Cell(Coordinate(0,0),false),Cell(Coordinate(0,1),true),Cell(Coordinate(0,2),true),Cell(Coordinate(0,3),true),
    Cell(Coordinate(1,0),true), Cell(Coordinate(1,1),true),Cell(Coordinate(1,2),true),Cell(Coordinate(1,3),false),
    Cell(Coordinate(2,0),true), Cell(Coordinate(2,1),true),Cell(Coordinate(2,2),true),Cell(Coordinate(2,3),false),
    Cell(Coordinate(3,0),false),Cell(Coordinate(3,1),true),Cell(Coordinate(3,2),true),Cell(Coordinate(3,3),true))

  @Test
  def itShouldCreateABoardWithGivenCells(): Unit ={
    //given

    //when
    val board:Board = Board(cells)

    //then
    board.cells should equal(cells)
  }

  @Test
  def itShouldGiveMeAliveNeighboursCount(): Unit = {
    //given

    val board:Board = Board(cells)
    //when

    //then
    board.aliveCountFor(Coordinate(0,0)) should equal(3)
  }

  @Test
  def itShouldGiveAliveCountForMultipleCellsOnBoard(): Unit ={
    //given

    //when
    val board:Board = Board(cells)

    //then
    board.aliveCountFor(Coordinate(0,0)) should equal(3)
    board.aliveCountFor(Coordinate(3,0)) should equal(3)
    board.aliveCountFor(Coordinate(0,3)) should equal(2)
    board.aliveCountFor(Coordinate(3,3)) should equal(2)
    board.aliveCountFor(Coordinate(2,1)) should equal(7)
  }

  @Test
  def itShouldApplyLawsAndGiveFirstGenerationBoard_InputA(): Unit ={
    //given
    val inputA = List(Cell(Coordinate(0,0),true),Cell(Coordinate(0,1),true)
                ,Cell(Coordinate(1,0),true), Cell(Coordinate(1,1),true))
    //when
    val board:Board = Board(inputA)

    //then
    board.nextGeneration() should equal(board)
  }

  @Test
  def itShouldApplyLawsAndGiveFirstGenerationBoard_InputB(): Unit ={
    //given
    val inputB = List(
        Cell(Coordinate(0,0),true),Cell(Coordinate(0,1),true),Cell(Coordinate(0,2),false),
        Cell(Coordinate(1,0),true),Cell(Coordinate(1,1),false), Cell(Coordinate(1,2),true),
        Cell(Coordinate(2,0),false),Cell(Coordinate(2,1),true), Cell(Coordinate(2,2),false))

    val expected = List(
      Cell(Coordinate(0,0),true),Cell(Coordinate(0,1),true),Cell(Coordinate(0,2),false),
      Cell(Coordinate(1,0),true),Cell(Coordinate(1,1),false), Cell(Coordinate(1,2),true),
      Cell(Coordinate(2,0),false),Cell(Coordinate(2,1),true), Cell(Coordinate(2,2),false))


    //when
    val board:Board = Board(inputB)
    val nextGenBoard = board.nextGeneration()

    //then
    nextGenBoard should equal(Board(expected))
  }

  @Test
  def itShouldApplyLawsAndGiveFirstGenerationBoard_InputC(): Unit ={
    //given
    val inputC = List(
      Cell(Coordinate(0,0),false),Cell(Coordinate(0,1),true),Cell(Coordinate(0,2),false),
      Cell(Coordinate(1,0),false),Cell(Coordinate(1,1),true), Cell(Coordinate(1,2),false),
      Cell(Coordinate(2,0),false),Cell(Coordinate(2,1),true), Cell(Coordinate(2,2),false))

    val expected = List(
      Cell(Coordinate(0,0),false),Cell(Coordinate(0,1),false),Cell(Coordinate(0,2),false),
      Cell(Coordinate(1,0),true),Cell(Coordinate(1,1),true), Cell(Coordinate(1,2),true),
      Cell(Coordinate(2,0),false),Cell(Coordinate(2,1),false), Cell(Coordinate(2,2),false))

    //when
    val board:Board = Board(inputC)
    println(board.cells)
    //then
    board.nextGeneration() should equal(Board(expected))
  }

}
