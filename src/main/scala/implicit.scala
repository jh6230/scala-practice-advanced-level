// implicitについて
import scala.language.implicitConversions

/*
ここに定義するとコンパイルエラーになる
implicitはトップレベルの階層には定義できない
*/
//  implicit class RichInt(val self: Int)

object Implicit {
  implicit class RichInt(val self: Int) {
  def isPositive: Boolean = self > 0
}

  def main(args: Array[String]): Unit = {
    // enrich my library パターンといわれる使われ方
    println(1.isPositive) // Int型がRichInt classに型変換されている
  }
}

/*
暗黙のパラメータによって、アルゴリズムの一部を抽出し、
コードの重複化を減らせる
*/

object ImplicitParameter {

  implicit val context = 2
  def main(args: Array[String]): Unit = {
    // どちらも返り値は2になるので、暗黙的に引数を渡せている状態
    printContext
    printContext2
    println("-------")
    println(IntAdder.sum(List(1,2,3))) //sum(List(1,2,3)(IntAdder))と補完される
    println(StringAdder.sum(List("a", "b", "c"))) // sum(List("a", "b", "c")(StringAdder))と補完される
  }

  def printContext(implicit ctx: Int): Unit = println(ctx)
  def printContext2(implicit ctx: Int): Unit = println(ctx)

   // トレイトを使ったコードの共通化
  trait Adder[T] {
    def zero: T
    def plus(x: T, y: T): T
  }

  implicit object IntAdder extends Adder[Int] {
    def zero: Int = 0
    def plus(x: Int, y: Int): Int = x + y
    // 同じスコープ内に書かないとコンパイルエラーになる
    def sum[T](list: List[T])(implicit adder: Adder[T]): T = list.foldLeft(adder.zero){ (x, y) => adder.plus(x, y) }
}

  implicit object StringAdder extends Adder[String] {
    def zero: String = ""
    def plus(x: String, y: String): String = x + y
    def sum[T](list: List[T])(implicit adder: Adder[T]): T = list.foldLeft(adder.zero){ (x, y) => adder.plus(x, y) }
  }

}
