package part2

import part2.Asserter.AssertionException


class AsserterTest(name: String) extends TestCase(name) {

  def testAssertDoesNotThrowIfActualValueEqualsExpectedValue(): Unit = {
    try {
      Asserter.assert(1, 1)
    } catch {
      case _: Throwable =>
        throw new RuntimeException("Assert threw an exception, even though it shouldn't have!")
    }
  }

  def testAssertThrowsIfActualValueDoesNotEqualExpectedValue(): Unit = {
    try {
      Asserter.assert("hello", "HELLO")
      throw new RuntimeException("Assert should have thrown an exception, but it didn't!")
    } catch {
      case _: AssertionException =>
      // that's what we expected

      case unintentionalException: RuntimeException =>
        throw unintentionalException
    }
  }

}