package part1


class Bank() {

  private var rates = scala.collection.mutable.HashMap.empty[Pair, Int]

  def addRate(from: String, to: String, rate: Int): Unit = {
    rates += (new Pair(from, to) -> rate)
  }

  def reduce(source: Expression, to: String): Money = {
    source.reduce(this, to)
  }

  def rate(from: String, to: String): Int = {
    if (from == to) 1
    else {
      val rate = rates.get(new Pair(from, to))
      rate.get
    }
  }
}