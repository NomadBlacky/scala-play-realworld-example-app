package core.users.test_helpers

import commons.models.Login
import core.authentication.api.PlainTextPassword
import core.users.models.UserRegistration

object UserRegistrations {
  val petycjaRegistration = UserRegistration(Login("petycja"), PlainTextPassword("a valid password"))
}