package jpr11

import scala.util.Random

object Game {
  //val previousGeneration:Board
  def evolve(oldBoard:Board):Board = {
    val newGrid = oldBoard.grid.map(entry => {
        val (location,cell) = entry
        (location, cell.nextGeneration(oldBoard.getLiveNeighbors(location)))
      })
    return new Board(newGrid) // <-- Implicit conversion from Iterable[Tuple2] to Map[Location,Cell]
  }

  def generateRandomBoard(width:Int, height:Int):Board = {
    val positions = for {
      x <- 0 to width
      y <- 0 to height
    } 
    yield Location(x,y)
    val randomGrid = Map(positions map {
        val cell:Cell = if(util.Random.nextBoolean) AliveCell else DeadCell
        (_, cell)
      }: _ *)

    return new Board(randomGrid)
  }
}

object Main {

  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    val initial = Game.generateRandomBoard(20, 20)
    println(initial)
    val generation1 = Game.evolve(initial)
    println(generation1)
    val generation2 = Game.evolve(initial)
    println(generation1)
    val generation3 = Game.evolve(initial)
    println(generation1)
  }

}
