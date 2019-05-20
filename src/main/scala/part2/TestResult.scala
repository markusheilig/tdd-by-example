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

  def summary = s"$runCount run, $errorCount failed"
}
