package com.comcast.ebi.rtcookbook.akka.core

import akka.actor.Actor

/**
  * Created by rmutya200 on 4/20/2017.
  */
class AkkaHello extends Actor {
  def receive = {
    case "hello" => println("hello back at you")
    case _  => println("huh?")
  }
}

class AkkaReply extends Actor {
  def receive = {
    case "Can You give me reply" => println("yes")
    case "send me a number" => println(10)
    case _ => println("empty")
  }
}

class AkkaAsk extends Actor {
  def receive = {
    case "who is great" => sender ! "you are the greatest"
    case "send me a number" => sender ! "10"
  }
}