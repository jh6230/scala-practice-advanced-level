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
