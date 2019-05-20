package part2

class TestResult {

  var runCount = 0
  var errorCount = 0

  def testStarted(): Unit = {
    runCount += 1
  }

  def testFailed(): Unit = {
    errorCount += 1
  }

  def combine(other: TestResult): TestResult = {
    val result = new TestResult()
    result.runCount = runCount + other.runCount
    result.errorCount = errorCount + other.errorCount
    result
  }

  def summary = s"$runCount run, $errorCount failed"
}
