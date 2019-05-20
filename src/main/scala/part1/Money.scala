package part1



class Money(val amount: Int, private val _currency: String) extends Expression {
  def reduce(bank: Bank, to: String): Money = {
    val rate = bank.rate(_currency, to)
    new Money(amount / rate, to)
  }

  override def equals(obj: Any): Boolean = {
    val money = obj.asInstanceOf[Money]
    amount == money.amount && currency() == money.currency()
  }

  override def plus(addend: Expression): Expression = new Sum(this, addend)

  def times(multiplier: Int): Expression = new Money(amount * multiplier, _currency)

  def currency(): String = _currency

  override def toString: String = s"$amount ${_currency}"
}

object Money {

  def dollar(amount: Int): Money = new Money(amount, "USD")

  def franc(amount: Int): Money = new Money(amount, "CHF")

}