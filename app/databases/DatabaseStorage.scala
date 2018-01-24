package databases

import com.google.inject.Inject
import play.api.Logger

trait DatabaseStorage {
  val pgContext = new io.getquill.PostgresAsyncContext(io.getquill.SnakeCase, "db.default")

}



trait DatabaseQueries extends DatabaseStorage {
  import pgContext._
  /*
  def executeForMultiple[T <: Class[T]](tableName: String, f: => Boolean): Future[Vector[T]] = {
    val qs = quote {
      querySchema[T](tableName)
    }
    val q: Quoted[Query[T]] = quote {
      qs.filter(u => f)
    }
    pgContext.run(q).mapTo[Vector[T]]
  }
  def executeForSingle[T](tableName: String, f: => Boolean): Future[Vector[T]] = {
    val qs = quote {
      querySchema[T](tableName)
    }
    val q: Quoted[Query[T]] = quote {
      qs.filter(u => f)
    }
    pgContext.run(q).mapTo[Vector[T]]
  }*/
}


class PostgresStorage @Inject() extends DatabaseStorage {
  val log = Logger("DatabaseStorage")
}
