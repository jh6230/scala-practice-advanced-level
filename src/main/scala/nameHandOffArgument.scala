// 名前渡し引数 引数の評価タイミングを制御する

object NameHandOffArgument {

  def main(args: Array[String]): Unit = {
    val n = 3
    if_(n % 2 == 1){ println("奇数") }{ println("偶数") }
    println("------------------------------------------")
    if__(n % 2 == 1){ println("奇数") }{ println("偶数") }
  }

  /*
   これではnが奇数だが、奇数と偶数の両方が表示されてしまう
   引数を呼び出し前に同時評価してしまっているから
   引数を呼び出し前に評価する方法を値渡しという
  */
  def if_[A](conditon: Boolean)(thenClause: A)(elseClause: A): A = {
    if (conditon) thenClause else elseClause
  }

  /*
   指定した引数に対して関数を呼び出したあとに必要に応じて評価するという機能をもつ
   引数の型名の前に => が付くのが特徴的
   => を遅延評価させたい引数に付ける
  */
  def if__[A](conditon: Boolean)(thenClause: => A)(elseClause: => A): A = {
    if (conditon) thenClause else elseClause
  }

}
