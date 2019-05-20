package part2

object TestRunner {

  def main(args: Array[String]): Unit = {
    val suite = new TestSuite()
    suite.add(new AsserterTest("testAssertDoesNotThrowIfActualValueEqualsExpectedValue"))
    suite.add(new AsserterTest("testAssertThrowsIfActualValueDoesNotEqualExpectedValue"))
    suite.add(new TestCaseTest("testTemplateMethod"))
    suite.add(new TestCaseTest("testResult"))
    suite.add(new TestCaseTest("testFailedResult"))
    suite.add(new TestCaseTest("testFailedResultFormatting"))
    suite.add(new TestCaseTest("testSuite"))
    val result = new TestResult()
    suite.run(result)
    println(result.summary)
  }

}