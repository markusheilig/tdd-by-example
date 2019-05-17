import org.scalatest.{FlatSpec, Matchers}


class MoneyTest extends FlatSpec with Matchers {

  "Money" should "define equality" in {
    Money.dollar(5) shouldBe Money.dollar(5)
    Money.dollar(5) shouldNot be(Money.dollar(6))
    Money.franc(5) shouldNot be(Money.dollar(5))
  }

  it should "have a currency" in {
    Money.dollar(1).currency() shouldBe "USD"
    Money.franc(1).currency() shouldBe "CHF"
  }

  it should "support multiplication" in {
    val five = Money.dollar(5)
    five.times(2) shouldBe Money.dollar(10)
    five.times(3) shouldBe Money.dollar(15)
  }

  it should "support simple addition" in {
    val five = Money.dollar(5)
    val sum: Expression = five.plus(five)
    val bank = new Bank()
    val reduced = bank.reduce(sum, "USD")
    reduced shouldBe Money.dollar(10)
  }

  it should "return a sum when summing money" in {
    val five = Money.dollar(5)
    val result = five.plus(five)
    val sum = result.asInstanceOf[Sum]
    sum.augend shouldBe five
    sum.addend shouldBe five
  }

  "A Bank" should "reduce a sum" in {
    val sum = new Sum(Money.dollar(3), Money.dollar(4))
    val bank = new Bank()
    val result = bank.reduce(sum, "USD")
    result shouldBe Money.dollar(7)
  }

  it should "reduce money" in {
    val bank = new Bank()
    val result = bank.reduce(Money.dollar(1), "USD")
    result shouldBe Money.dollar(1)
  }

  it should "reduce money with different currency" in {
    val bank = new Bank()
    bank.addRate("CHF", "USD", 2)
    val result = bank.reduce(Money.franc(2), "USD")
    result shouldBe Money.dollar(1)
  }

  it should "provide an identity rate" in {
    new Bank().rate("USD", "USD") shouldBe 1
  }

  it should "add mixed currencies" in {
    val fiveBucks: Expression = Money.dollar(5)
    val tenFrancs: Expression = Money.franc(10)
    val bank = new Bank()
    bank.addRate("CHF", "USD", 2)
    val result: Money = bank.reduce(fiveBucks.plus(tenFrancs), "USD")
    result shouldBe Money.dollar(10)
  }

  "An Expression" should "reduce sums with money" in {
    val fiveBucks: Expression = Money.dollar(5)
    val tenFrancs: Expression = Money.franc(10)
    val bank = new Bank()
    bank.addRate("CHF", "USD", 2)
    val sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks)
    val result = bank.reduce(sum, "USD")
    result shouldBe Money.dollar(15)
  }

  "A Sum" should "support multiplication" in {
    val fiveBucks: Expression = Money.dollar(5)
    val tenFrancs: Expression = Money.franc(10)
    val bank = new Bank()
    bank.addRate("CHF", "USD", 2)
    val sum = new Sum(fiveBucks, tenFrancs).times(2)
    val result = bank.reduce(sum, "USD")
    result shouldBe Money.dollar(20)
  }

}