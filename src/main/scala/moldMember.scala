// 型メンバについて クラスやトレイと内だけで有効な型の別名を付ける

class TypeMembers {
  type T = String
  val t: T = "Foo"
}

/*
クラスTypeMembersの中で定義された型Tを
TypeMembersのメンバである型といい、通称型メンバという。
ここでTはString型の別名になる。
このように型メンバはクラスやトレイとの中だけで有効な型の別名を付ける
ことによってコードの可読性を向上させる。
 */

trait Stacks {
  type T
  sealed abstract class Stack {
    def isEmpty: Boolean
    def top: T
    def pop: Stack
    def push(e: T): Stack = NonEmptyStack(e, this)
  }

  case class NonEmptyStack(head: T, tail: Stack) extends Stack {
    def isEmpty: Boolean = false
    def top: T = head
    def pop: Stack = tail
  }

  case object EmptyStack extends Stack {
    def isEmpty: Boolean = true
    def top: T = ???
    def pop: Stack = ???
  }
}

/* ミックスインの先でTに実際の型を定義することによってIntStacks内部で
   Int型を要素とするStackが扱えるようになっている。
*/
class IntStacks extends Stacks {
  type T = Int
  val stack = EmptyStack.push(1).push(2).push(3)
}

object MoldMember {
  def main(args: Array[String]): Unit = {
    val intStacks = new IntStacks
    println(intStacks.stack.top) // 3
  }
}
