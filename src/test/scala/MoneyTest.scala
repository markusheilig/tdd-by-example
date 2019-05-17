import org.scalatest.{FlatSpec, Matchers}

class Money(private val amount: Int, private val _currency: String) {

  override def equals(obj: Any): Boolean = {
    val money = obj.asInstanceOf[Money]
    amount == money.amount && currency() == money.currency()
  }

  def plus(added: Money): Money = new Money(amount + added.amount, _currency)

  def times(multiplier: Int): Money = new Money(amount * multiplier, _currency)

  def currency(): String = _currency

  override def toString: String = s"$amount ${_currency}"
}

object Money {

  def dollar(amount: Int): Money = new Money(amount, "USD")

  def franc(amount: Int): Money = new Money(amount, "CHF")

}


class MoneyTest extends FlatSpec with Matchers {

  "Money" should "define equality" in {
    Money.dollar(5) shouldBe Money.dollar(5)
    Money.dollar(5) shouldNot be(Money.dollar(6))
    Money.franc(5) shouldNot be(Money.dollar(5))
  }

  it should "support multiplication" in {
    val five = Money.dollar(5)
    five.times(2) shouldBe Money.dollar(10)
    five.times(3) shouldBe Money.dollar(15)
  }

  it should "add with the same currency" in {
    val sum = Money.dollar(5).plus(Money.dollar(5))
    sum shouldBe Money.dollar(10)
  }

  it should "have a currency" in {
    Money.dollar(1).currency() shouldBe "USD"
    Money.franc(1).currency() shouldBe "CHF"
  }

}

