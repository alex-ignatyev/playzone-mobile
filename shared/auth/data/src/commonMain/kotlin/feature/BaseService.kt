package feature

import api.core.ErrorCode
import com.realcosmetology.android.utils.api.core.Answer
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

abstract class BaseRemoteDataSource {

    protected suspend inline fun <reified T : Any> apiCall(call: () -> HttpResponse): Answer<T> {
        val response = try {
            call.invoke()
        } catch (e: Exception) {
            return Answer.failure(code = ErrorCode.InternalError)
        }

        return when (response.status.value) {
            400 -> Answer.failure(
                code = ErrorCode.BadRequest,
                message = response.body()
            )
            409 -> Answer.failure(
                code = ErrorCode.Conflict,
                message = response.body()
            )
            else -> Answer.success(response.body())
        }
    }
}
