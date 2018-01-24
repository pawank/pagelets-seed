package models

import play.api.libs.json.Json

object Size {
  implicit val format = Json.format[Size]
}

case class Size(width: Int, height: Int)

object Image {
  implicit val format = Json.format[Image]
  def empty = Image(src = "#", size = Size(100,100), alt = "Sample image", title = Some("Sample image"))
}

case class Image(src: String, size: Size, alt: String, title: Option[String] = None)
