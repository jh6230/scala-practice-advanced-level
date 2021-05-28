// classOfについて

/*
classOfはクラスに対して、そのクラスを表すClass型のオブジェクトを取得するためのメソッド。
主に、実行時にクラス情報を取得して、それにもとづいてプログラミングを行うために使用される。
*/

object ClassOf {
  def main(args: Array[String]): Unit = {
    val stringClass = classOf[String]
    println(stringClass) // class java.lang.String
    val stringMethods     = stringClass.getMethods.toList // String型がもつメソッドをリスト型にして取得
    val iMethods    = stringMethods.filter{_.getName.startsWith("i")}
    println(iMethods)
  }

  /*
  isInstansOf
  以下のようなコードがあった時に、bに入っている実際のインスタンスはAクラスのインスタンス
  だが、それをチェックするためにisInstansOfというメソッドが用意されている
  */
  class B
  class A extends B
  val b: B = new A
  println(b.isInstanceOf[A]) // true

  /*
  asInstansOf
  asInstansOfは、クラスのキャスト（変換）を行う特別なメソッド。
  Scalaは静的型付けなので、型安全性を壊す可能性があるキャストは使用するべきではないが、
  型がAnyになっている場合などはキャストが必要な場合がある
  キャストが失敗した場合、ClassCastExceptionが発生するので取り扱いには注意が必要
  */

  val any: Any =  "99"
  // val any: Any =  99 //これだとClassCastExceptionが発生 型推論でIntになっているから
  println(any.asInstanceOf[String])

}
