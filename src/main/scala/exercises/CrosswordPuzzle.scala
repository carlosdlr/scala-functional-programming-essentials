package exercises

object CrosswordPuzzle extends App {

  val crossword = Array(
    "+-++++++++",
    "+-++++++++",
    "+-++++++++",
    "+-----++++",
    "+-+++-++++",
    "+-+++-++++",
    "+++++-++++",
    "++------++",
    "+++++-++++",
    "+++++-++++"
  )

  val words = "LONDON;DELHI;ICELAND;ANKAR"

  def crosswordPuzzle(crossword: Array[String], words: String): Array[String] = {
    def crosswordPuzzleRec(crossword: Array[String], words: String, i: Int = 0): Array[String] = {
      if(i >= crossword.length) crossword
      else
        crossword.update(i, processingPuzzleRow(crossword(i), words.split(";")))
        crosswordPuzzleRec(crossword, words, i + 1)
    }

    def processingPuzzleRow(row: String, words: Array[String], i: Int = 0): String = {
      val availableSpotsPositions = row.toArray.zipWithIndex.filter(pair => pair._1.equals('-')).map(pair => pair._2)
      if(i >= words.length) row
      else {
        var updatedRow = row
        if (availableSpotsPositions.length == 1)
          updatedRow = row.updated(availableSpotsPositions(0), words(i).charAt(0))

        processingPuzzleRow(updatedRow, words, i + 1)
      }
    }

    crosswordPuzzleRec(crossword, words)
  }

  crosswordPuzzle(crossword, words).foreach(println)

}
