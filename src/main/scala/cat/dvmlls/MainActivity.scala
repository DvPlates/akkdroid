package cat.dvmlls

import java.util.concurrent.TimeUnit

import akka.actor.{Props, Actor, ActorSystem}
import akka.util.Timeout
import android.app.Activity
import android.os.Bundle
import akka.pattern.ask
import scala.language.implicitConversions

class MainActivity extends Activity with TypedFindView {

  implicit def funToRunnable(fun: () => Unit):Runnable = new Runnable() {
    def run() = fun()
  }

  class Backgrounder extends Actor {
    override def receive: Receive = {
      case s: String =>
        Thread.sleep(5 * 1000)
        textview.post(() => { textview.setText(s) } )
    }
  }

  lazy val textview = findView(TR.text)

  implicit lazy val system = ActorSystem("farts")
  implicit lazy val timeout = new Timeout(10, TimeUnit.SECONDS)
  implicit lazy val executionContext = system.dispatcher
  lazy val a = system.actorOf(Props { new Backgrounder() }, "backgrounder")

  /** Called when the activity is first created. */
  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main)
    textview.setText("Hello world, from Farts")

    a ! "hi"
  }

}