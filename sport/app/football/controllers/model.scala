package football.controllers

import common.Pagination
import model.{Page, Trail, MetaData, Competition}
import org.joda.time.LocalDate
import implicits.Football

case class MatchesOnDate(date: LocalDate, competitions: Seq[Competition])

case class CompetitionFilter(name: String, url: String)

case class MatchesPage(
    page: MetaData,
    blog: Option[Trail],
    days: Seq[MatchesOnDate],
    nextPage: Option[String],
    previousPage: Option[String],
    pageType: String,
    filters: Map[String, Seq[CompetitionFilter]] = Map.empty,
    comp: Option[Competition]) extends Football {

  lazy val isLive = days.flatMap(_.competitions.flatMap(_.matches)).exists(_.isLive)
  lazy val urlBase = comp.map(c => c.url).getOrElse("/football")

}

class FootballPage(
            id: String,
            section: String,
            webTitle: String,
            analyticsName: String,
            pagination: Option[Pagination] = None,
            description: Option[String] = None) extends Page(
  id,
  section,
  webTitle,
  analyticsName,
  pagination,
  description
) {
  override val hasClassicVersion: Boolean = false
}