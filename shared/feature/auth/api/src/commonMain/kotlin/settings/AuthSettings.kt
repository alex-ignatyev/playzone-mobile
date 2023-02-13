package settings

interface AuthSettings {
    fun saveToken(token: String)
    fun fetchToken(): String
}
