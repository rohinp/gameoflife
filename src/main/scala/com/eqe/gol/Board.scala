package com.eqe.gol

case class Board(cells:List[Cell]) {

  val validLifeCounts = List(2, 3)

  def aliveCountFor(coordinate: Coordinate):Int = {

    def loop(li:List[(Int,Int)],acc:Int):Int = li match {
      case List() => acc
      case x::xs => loop(xs,acc + (cells.find(c => c.coordinate.equals(Coordinate(x._1,x._2))) match {
        case Some(AliveCell(_)) => 1
        case _ => 0
      }))
    }
    loop(coordinate.neighbours,0)
  }

  def nextGeneration():Board = Board(
    cells.map(c => aliveCountFor(c.coordinate) match {
      case 3 => Cell(c.coordinate,isAlive = true)
      case x if x < 2 || x > 3 => Cell(c.coordinate,isAlive = false)
      case _ => c
    }))
}
