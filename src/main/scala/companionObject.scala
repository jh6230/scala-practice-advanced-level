case class Person private (name: String, age: Int) {
  val introduce: String =  "初めまして私は" + name +  "で、" + age + "歳" + "です"
}
/*
コンパニオンオブジェクト
クラス名と同じ名前のオブジェクト
privateなコンストラクタは外側から呼び出すことはできないが
コンパニオンオブジェクトは同名クラス名にアクセスできる
*/

object Person {
  def apply(name: String, age: Int): Person = new Person(name, age)
}

/*
例えば以下のようなオブジェクトを定義すると
cannot be accessed in object Men
というエラーがでてしまい、コンパイルが通らない

object Men {
   def apply(name: String, age: Int): Person = new Person(name, age)
 }
*/

object Main {
  def main(args: Array[String]): Unit = {

    println("test")
    println(Person("hoge", 32).introduce)
  }
}
