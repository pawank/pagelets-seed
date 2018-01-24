package service

import com.google.inject.Inject
import databases.DatabaseStorage
import models.Teaser
import play.api.i18n.Lang

import scala.concurrent.{ExecutionContext, Future}

trait CarouselService {
  def carousel(implicit lang: Lang, ec: ExecutionContext): Future[Seq[Teaser]]
}

class CarouselServiceImpl @Inject()(ws: WsConsumer, db: DatabaseStorage) extends CarouselService with PlayPort {
  override def carousel(implicit lang: Lang, ec: ExecutionContext) = {
    import db.pgContext._
    try {
      case class AuthUser(id: Long, email: Option[String], username: String)
      val users = quote {
        querySchema[AuthUser]("auth_user", _.email-> "email")
      }
      val q: Quoted[Query[AuthUser]] = quote {
        users.filter(u => u.id > 0)
      }
      db.pgContext.run(q).map(x => println(x))
    }catch {
      case e: Exception =>
        e.printStackTrace()
    }
    ws.fetch[Seq[Teaser]](s"http://localhost:$port/mock/carousel")
  }
}
