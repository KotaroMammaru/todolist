case class Todo(val name :String, val period:String){
  println("追加しました")
  def printTodo():String = {
    this.name + "/期限:" + this.period
  }
}
