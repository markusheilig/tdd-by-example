package part2

object TestRunner {

  def main(args: Array[String]): Unit = {
    new AsserterTest("testAssertDoesNotThrowIfActualValueEqualsExpectedValue").run()
    new AsserterTest("testAssertThrowsIfActualValueDoesNotEqualExpectedValue").run()
    new TestCaseTest("testTemplateMethod").run()
    new TestCaseTest("testResult").run()
    new TestCaseTest("testFailedResult").run()
    new TestCaseTest("testFailedResultFormatting").run()
  }

}