
class Sum(var augend: Expression, var addend: Expression) extends Expression {

  def times(multiplier: Int): Expression = {
    new Sum(augend.times(multiplier), addend.times(multiplier))
  }

  def reduce(bank: Bank, to: String): Money = {
    val amount = augend.reduce(bank, to).amount + addend.reduce(bank, to).amount
    new Money(amount, to)
  }

  override def plus(addend: Expression): Expression = {
    new Sum(this, addend)
  }
}
