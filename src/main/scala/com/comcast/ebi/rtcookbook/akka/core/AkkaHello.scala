package com.comcast.ebi.rtcookbook.akka.core

/**
  * Created by rmutya200 on 4/20/2017.
  */
import akka.actor._


import scala.concurrent.duration._
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Main extends App {
  val system = ActorSystem("HelloSystem")
  // default Actor constructor
  val helloActor = system.actorOf(Props[AkkaHello], name = "akkahello")
  val akkaReply = system.actorOf(Props[AkkaReply])
  val akkaAsk = system.actorOf(Props[AkkaAsk])

  helloActor ! "hello"
  helloActor ! "buenos dias"
  akkaReply ! "Can You give me reply"
  akkaReply ! "send me a number"
  akkaReply ! ""
  implicit val timeout: Timeout = 3 seconds
  val replyf:Future[Any] = akkaAsk ? "who is great" // equivalent to recipient.ask("Hello")
  replyf.onSuccess{
    case reply => println(reply.toString)
  }
  system.shutdown
}
