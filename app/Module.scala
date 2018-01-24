import com.google.inject.AbstractModule
import databases.{DatabaseStorage, PostgresStorage}
import service._

class Module extends AbstractModule {

  override def configure() = {
    bind(classOf[DatabaseStorage]).to(classOf[PostgresStorage]).asEagerSingleton()
    bind(classOf[WsConsumer]).to(classOf[WsConsumerImpl]).asEagerSingleton()
    bind(classOf[TeaserService]).to(classOf[TeaserServiceImpl]).asEagerSingleton()
    bind(classOf[CarouselService]).to(classOf[CarouselServiceImpl]).asEagerSingleton()
    bind(classOf[TextblockService]).to(classOf[TextblockServiceImpl]).asEagerSingleton()
  }
}