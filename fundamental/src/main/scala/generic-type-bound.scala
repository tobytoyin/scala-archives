trait ItemInterface:
  def printID(): Unit

class Item(id: String) extends ItemInterface:
  def printID(): Unit = println(id)

class Container[T <: ItemInterface]:
  var objects: List[T] = Nil

  def add(item: T): Unit =
    objects = objects :+ item

  def printAllID(): Unit =
    objects.foreach(item => item.printID())

@main def main(): Unit =

  val container = Container[Item]()
  container.add(Item("A"))
  container.add(Item("B"))
  container.add(Item("C"))
  container.printAllID()
