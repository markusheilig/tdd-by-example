package part2

object Asserter {

  final case class AssertionException(message: String) extends RuntimeException(message) {

  }

  def assert[T](expected: T, actual: T): Unit = {
    if (expected != actual) {
      throw AssertionException(s"expected '$expected' but got '$actual'")
    }
  }

}
