import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import settings.AuthSettings

class SettingsAuthDataSource(
    private val settings: Settings
) : AuthSettings {

    override fun saveToken(token: String) {
        settings.putString(tokenKey, "Bearer $token")
    }

    override fun fetchToken(): String {
        return settings[tokenKey, ""]
    }

    companion object {
        private val tokenKey = "tokenKey"
    }
}
