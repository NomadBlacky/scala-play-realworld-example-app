package core.commons.controllers

import core.config.JsonMappings
import play.api.libs.json.{JsError, Reads}
import play.api.mvc.{AbstractController, BodyParser, ControllerComponents}

import scala.concurrent.ExecutionContext

abstract class RealWorldAbstractController(controllerComponents: ControllerComponents)
  extends AbstractController(controllerComponents)
    with JsonMappings {

  implicit protected val executionContext: ExecutionContext = defaultExecutionContext

  protected def validateJson[A : Reads]: BodyParser[A] = parse.json.validate(
    _.validate[A].asEither.left.map(e => BadRequest(JsError.toJson(e)))
  )

}