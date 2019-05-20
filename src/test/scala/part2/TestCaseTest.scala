package part2

class TestCaseTest(name: String) extends TestCase(name) {

  def testTemplateMethod(): Unit = {
    val test = new WasRun("testMethod")
    test.run()
    Asserter.assert("setUp testMethod tearDown ", test.log)
  }

  def testResult(): Unit = {
    val test = new WasRun("testMethod")
    val result = test.run()
    Asserter.assert("1 run, 0 failed", result.summary)
  }

  def testFailedResult(): Unit = {
    val test = new WasRun("testBrokenMethod")
    val result = test.run()
    Asserter.assert("1 run, 1 failed", result.summary)
  }

  def testFailedResultFormatting(): Unit = {
    val result = new TestResult()
    result.testStarted()
    result.testFailed()
    Asserter.assert("1 run, 1 failed", result.summary)
  }

}

