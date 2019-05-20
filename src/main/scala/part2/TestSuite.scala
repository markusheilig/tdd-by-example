package part2

class TestSuite() {

  private val tests = scala.collection.mutable.ListBuffer.empty[TestCase]

  def add(test: TestCase): Unit = {
    tests += test
  }

  def run(testResult: TestResult): Unit = {
    tests.foreach(test => test.run(testResult))
  }

}
