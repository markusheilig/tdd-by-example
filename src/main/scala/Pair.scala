
class Pair(var from: String, var to: String) {
  override def equals(obj: Any): Boolean = {
    val pair = obj.asInstanceOf[Pair]
    from == pair.from && to == pair.to
  }

  override def hashCode(): Int = 0
}
