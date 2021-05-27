// 型パラメータについて

/*
型パラメータを使用することによってクラス定義時には予測できない
要素の型に対応すると同時に、そのような要素の安全に扱うことができる
*/

case class Car(brand: String, year: Int ) {
  val sentence = s"メーカーは${brand}で, 製造年は${year}年です"
}

// Car class を型パラメータAとして定義このクラスの中ではCarクラスをAとして扱うことができる
case class Cell[A](car: A) {
  def get: A = car
}

object  TypeParameter {
  def main(args: Array[String]): Unit = {
    val car = Car("トヨタ", 2021) // 引数では直接渡せないので、Carクラスのインスタンスを生成
    val cell = Cell[Car](car)
    println(cell.get.sentence)
  }
}
