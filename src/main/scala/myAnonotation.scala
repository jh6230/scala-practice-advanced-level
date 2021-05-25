// 自分型アノテーションにについて (トレイトやクラスに継承でない依存関係をもたせる)

/*
自分型アノテーションはトレイト間の依存関係とは
別に定義できるため、依存性の注入に利用できる。
 */
trait ModuleA {
  def methodA(): Unit
}

/*
trait ModuleB extends ModuleA {
  def methodA(): Unit = ???
}
トレイと自体を継承させようとすると上記のような記述をするが、
これでは「ModuleB is ModuleA」という関係性になってしまい、直接の継承関係
を持たせない時には使えない。
 */

// 以下のように書けばよい
trait ModuleB { self: ModuleA =>
  def methodB(): Unit = methodA()
}

// ModuleBは最終的にModuleAを継承しているので、ModuleAもクラスの中に組み込む必要がある
class ClassC(val name: String, val age: Int) extends ModuleB with ModuleA {
  def methodA(): Unit = println(s"私の名前は ${name} で、${age}歳です。")
}

object MyAnonotation {
  def main(args: Array[String]): Unit = {
    val classC = new ClassC("山田太郎", 25)
    classC.methodA()
  }
}
