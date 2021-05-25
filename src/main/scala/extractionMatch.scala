// 抽出子

/*
抽出子を定義するにはオブジェクト、もしくはクラスを定義し、そのオブジェクトや
クラスにunapplyメソッドを定義する。
unapplyメソッドの引数がmatch式で対象にする式になるので、matchさせたい型と引数の型を
合わせる。
*/

object Positive {
  def unapply(n: Int): Option[Int] = if (n > 0) Some(n) else None
}

object ExtractionMatch {
  def main(args: Array[String]): Unit  = {
    judgeMentPositive()
  }

  def judgeMentPositive(): Unit = {
    1 match {
      case Positive(_) => println("1 is Positive")
      case _  => println("1 is not Postive")
    }
    -1 match {
      case Positive(_) => println("-1 is Postive")
      case _ => println("-1 is not Postive")
    }
  }
}
