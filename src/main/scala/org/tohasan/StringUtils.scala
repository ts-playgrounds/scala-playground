package org.tohasan

object StringUtils {

  implicit class StringEnhancements(val s: String) {
    def increment: String = s.map(c => (c + 1).toChar)
    def hello: String = s"Hello ${s.capitalize}!"
  }
}
