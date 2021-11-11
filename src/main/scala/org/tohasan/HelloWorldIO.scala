package org.tohasan

import cats.effect.{ExitCode, IO, IOApp}

object HelloWorldIO extends IOApp.Simple {

  val meaningOfLife: IO[Int] = IO(42)
  val favLang: IO[String] = IO("Scala")

  implicit class IOExtensions(io: IO[_]) {
    def debug: IO[_] = io.map { value =>
      println(s"[${Thread.currentThread().getName}] $value")
      value
    }
  }

  def sameThread(): IO[Unit] = for {
    _ <- meaningOfLife.debug
    _ <- favLang.debug
  } yield ()

  override def run: IO[Unit] = {
    println(s"[${Thread.currentThread().getName}] start")
    sameThread().as(ExitCode.Success)
  }
}
