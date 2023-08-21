import scala.io.StdIn

class Account(private var balance: Double) {
  def deposit(amount: Double): Unit = {
      balance += amount
      print("New balance: " + balance)
  }

  def withdraw(amount: Double): Boolean = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      print("New balance: " + balance)
      true
    } else {
      println("Withdrawal amount must be less than the balance.")
      false
    }
  }

  override def toString: String = f"Account balance: $balance%.2f"
}

object AccountDemo {
  def main(args: Array[String]): Unit = {
    val account = new Account(1000.0)
    println("Your balance is: " + account.toString)

    print("Enter 'D' for deposit or 'W' for withdrawal: ")
    val choice = StdIn.readLine()

    if (choice.equalsIgnoreCase("D")) {
      print("Enter deposit amount: ")
      val amount = StdIn.readDouble()
      account.deposit(amount)
    } else if (choice.equalsIgnoreCase("W")) {
      print("Enter withdraw amount: ")
      val amount = StdIn.readDouble()
      account.withdraw(amount)
    }
  }
}
