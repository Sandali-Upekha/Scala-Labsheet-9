class BankAccount(private var balance: Double) {
  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05
    } else {
      balance += balance * 0.1
    }
  }
  
  def getBalance: Double = balance

  override def toString: String = f"Account balance: $balance%.2f"
}

object Bank {
  def getAccountsNegativeBalance(accounts: List[BankAccount]): List[BankAccount] = {
    accounts.filter(account => account.getBalance < 0)
  }

  def calculateTotalBalance(accounts: List[BankAccount]): Double = {
    accounts.map(_.getBalance).sum
  }

  def applyInterestToAccounts(accounts: List[BankAccount]): Unit = {
    accounts.foreach(_.applyInterest())
  }
}

object BankDemo {
  def main(args: Array[String]): Unit = {
    println("---------assuming that the bank have two accounts, one with a positive balance 1000 and other with a negative balance 500.---------\n\n")

    val account1 = new BankAccount(1000.0)
    val account2 = new BankAccount(-500.0)

    val bankAccounts = List(account1, account2)

    val negativeBalanceAccounts = Bank.getAccountsNegativeBalance(bankAccounts)
    println("Accounts with negative balances")
    negativeBalanceAccounts.foreach(println)


    val totalBalance = Bank.calculateTotalBalance(bankAccounts)
    println(s"\nTotal balance of all accounts: $totalBalance")

    Bank.applyInterestToAccounts(bankAccounts)

    println("\nUpdated account balances after applying interest:")
    bankAccounts.foreach(println)
  }
}

