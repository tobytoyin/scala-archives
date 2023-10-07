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

trait AdapteeInterface:
  // an Interface for classes which contains `specificRequests`
  def specificRequest(): Unit

class Adapter[T <: AdapteeInterface](adaptee: T) extends TargetInterface:
  def request(): Unit =
    adaptee.specificRequest()

@main def main(): Unit =
  val client = Client()

  // as an ad-hoc way to indicate ExternalModule shares AdapteeInterface
  class Adaptee extends ExternalModule with AdapteeInterface
  val externalMod = Adaptee()

  val adapter = Adapter[AdapteeInterface](externalMod)

  client.run(adapter)
