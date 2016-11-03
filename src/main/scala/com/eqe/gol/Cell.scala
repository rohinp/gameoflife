package com.eqe.gol

trait Cell {
  val coordinate:Coordinate
  def toggleLife():Cell
}

case class AliveCell(coordinate:Coordinate) extends Cell{
  override def toggleLife(): Cell = DeadCell(coordinate)
}
case class DeadCell(coordinate:Coordinate) extends Cell {
  override def toggleLife(): Cell = AliveCell(coordinate)
}

object Cell {
  def apply(co:Coordinate,isAlive:Boolean):Cell = if(isAlive) AliveCell(co) else DeadCell(co)
}


