package org.scalafmt

import org.scalafmt.Error.CantFormatFile
import org.scalafmt.internal.Split

sealed abstract class Formatted {
  def get: String = this match {
    case Formatted.Success(code) => code
    case Formatted.Failure(e) => throw e
  }
}

object Formatted {
  case class Success(formattedCode: String) extends Formatted
  case class Failure(e: Throwable) extends Formatted
}