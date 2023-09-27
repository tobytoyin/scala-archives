object DrawImplicit {
  // implicit function doesn't need to have all the parameters passed
  // compiler will search the context scope and implicit get and pass automatically
  case class Colour(value: String)

  def draw(text: String)(implicit colour: Colour): String =
    s"[with: $colour] { $text }"

}

@main def ImplicitFunction(): Unit =
  import DrawImplicit._

  // implicit parameters are required to defined and pass as fn parameters
  // what needs to be done is to indicate the following:
  // - within the context, make a variable/ object as `implicit`
  // - such that the implicit parameters will go and look for those "implicit variables"
  implicit val red: Colour = Colour("red")
  val content: String = draw("hello world")

  println(content)
