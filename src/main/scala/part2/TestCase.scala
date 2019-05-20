package part2

class TestCase(name: String) {

  def setUp(): Unit = {
  }

  def tearDown(): Unit = {
  }

  def run(result: TestResult = new TestResult()): TestResult = {
    result.testStarted()
    setUp()
    try {
      val method = getClass.getMethod(name)
      method.invoke(this)
    } catch {
      case _: Throwable =>
        result.testFailed()
    }
    tearDown()
    result
  }

}