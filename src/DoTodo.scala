import java.util.Scanner
object DoTodo extends App {
  var todoList: Array[Todo]= Array()
  var move: Boolean = true
  println("起動")
  while (move){
    val s1:Scanner = new Scanner(System.in)
    val s2:Scanner = new Scanner(System.in)
    val s3:Scanner = new Scanner(System.in)


    println("現在のタスク")
    this.todoList match {
      case Array() => println("ありません")
      case _ => for (t <- this.todoList) println(t.printTodo())
    }
    println("どうしますか？")
    println(
      """1.タスクの追加
        |2.タスクの削除
        |3.終了
        |""".stripMargin)
    val ans:Int = s1.nextInt()
    ans match {
      case 1 =>
        println("タスク名を入力してください:")
        val name :String = s2.next()
        println("期限を入力してください:")
        val period: String = s3.next()
        val todo: Todo = Todo(name, period)
        todoList = todoList :+ todo
      case 2 =>
        todoList match {
          case Array() => println("現在タスクはありません")
          case _ =>
            println("どのタスクを削除しますか")
            var i:Int = 0
            for (t <- todoList){
              i += 1
              println(s"$i.${t.printTodo()}")
            }
            val del: Int = s2.nextInt()
            if (del <= this.todoList.length && del> 0){
              val to:Todo = this.todoList(del-1)
              this.todoList = this.todoList.filterNot(_==to)
              println("削除しました")
            }else println("その番号のタスクは存在しません")
        }
      case 3 => move = false
      case _ => println("ちゃんと入力してください")
    }
  }



}