object DrawExplicit {
  // ordinary function which needs to have all the inputs
  // explicitly passed as parameters
  case class Colour(value: String)

  def draw(text: String, colour: Colour): String =
    s"[with: $colour] { $text }"

}

@main def ExplicitFunction(): Unit =
  import DrawExplicit._

  // explicit parameters are required to defined and pass as fn parameters
  val red: Colour = Colour("red")
  val content: String = draw("hello world", colour = red)

  println(content)
