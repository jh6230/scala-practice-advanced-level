// 部分関数 PartialFunction(呼び出し前の引数チェック)について

/*
ある関数を呼び出す時に、特定の引数で呼び出した場合に必ず
成功するかどうかを関数本体を実行せずに確認したい場合

*/

object PartFunction {
  def main(args: Array[String]): Unit = {
    val fooPf:PartialFunction[String,String] = { case "foo" => "bar" }
    println(judgeMent("foo")) // bar
    println(judgeMent("hoge"))

  def judgeMent(str :String): String = {
    // isDefinedAtは引数に対して結果を返すかどうかを調べることができる
    if(fooPf.isDefinedAt(str)) {
      fooPf(str)
    } else {
      "合致しません"
    }
  }

    val list: List[Int] = List(1,2,3,4,5,6,7,8,9,10)
    val dbl: PartialFunction[Int, Int] = { case n if n % 3 == 0 => n * 10 }
    // 引数として部分関数を使用する代表的な例
    def mulitple(list: List[Int]): List[Int] = list.collect(dbl)
    println(mulitple(list))
  }

}
