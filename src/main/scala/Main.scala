
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.concurrent.ExecutionContext.Implicits.global

object Main extends App{
  // Main thread
  val mainThreadPromise = scala.concurrent.Promise[Int]()
  val promiseFuture = mainThreadPromise.future

  // DB config
  val db = Database.forConfig("mydb")

  val q = test.findByName("맥스")
  val qResult = q.result

  // query 문 확인
  println(qResult.statements)

  db.run(qResult) map (s => {
    // Print query result
    println(s)
    // main thread 종료
    mainThreadPromise.success(1)
    s
  })

  // Main thread promise 가 success 1을 반환하면 종료
  Await.result(promiseFuture, Duration.Inf)
}

object test extends TableQuery(new TestTable(_)) {
  val findByName = this.findBy(_.name)
}

import com.typesafe.config.ConfigFactory
class TestTable(tag: Tag) extends Table[(Int, String)](tag, Some(ConfigFactory.load().getString("mydb.custom.targetSchema")), ConfigFactory.load().getString("mydb.custom.testTableName")) {
  def id = column[Int]("id", O.PrimaryKey)
  def name = column[String]("name_ko")
  def * = (id, name)
}