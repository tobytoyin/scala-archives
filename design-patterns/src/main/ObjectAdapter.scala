trait TargetInterface:
  def request(): Unit

class Client:
  // out Client class only knows about TargetInterface
  // and uses it `request()` method to run the class method
  def run(target: TargetInterface): Unit =
    println("running Client method")
    target.request()

class ExternalModule:
  // ExternalModule represents a class that implemented/ import from external modules
  // it has their only method that are incompatible to the Client's interface
  def specificRequest(): Unit =
    println("External ModuleA request method")

class Adapter[T <: ExternalModule](adaptee: T) extends TargetInterface:
  def request(): Unit =
    adaptee.specificRequest()

@main def main(): Unit =
  val client = Client()

  val externalMod = ExternalModule()

  val adapter = Adapter[ExternalModule](externalMod)

  client.run(adapter)
