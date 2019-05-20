package part2


class WasRun(name: String) extends TestCase(name) {

  var log: String = _

  def testMethod(): Unit = {
    log = log + "testMethod "
  }

  def testBrokenMethod(): Unit = {
    throw new RuntimeException()
  }

  override def setUp(): Unit = {
    log = "setUp "
  }

  override def tearDown(): Unit = {
    log = log + "tearDown "
  }

}

