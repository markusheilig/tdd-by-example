package part2

class TestCase(name: String) {

  def setUp(): Unit = {
  }

  def tearDown(): Unit = {
  }

  def run(): TestResult = {
    val result = new TestResult()
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