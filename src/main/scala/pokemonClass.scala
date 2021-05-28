/*
ポケモンで学ぶクラスとオブジェクト指向
*/

// ポケモンクラス(抽象クラス)子クラスに継承されることを目的として作成される
abstract class Pokemon{
  val name:  String
  val type1: String
  val type2: String
  val hp:    Int

  def attack(): String = s"${name}のこうげき"
}

case class Pikachu(
  name:  String = "",
  type1: String = "",
  type2: String = "",
  hp:    Int    = 100
) extends Pokemon


object PokemonClass {
  def main(args: Array[String]): Unit = {
    // クラスのインスタンス（実体）を生成
    val pikachu = Pikachu("ピカチュウ")
    println(pikachu.name)
    print(pikachu.attack())
  }
}
