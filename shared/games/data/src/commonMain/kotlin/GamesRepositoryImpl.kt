import bd.SqlDelightGamesDataSource
import ktor.KtorGamesDataSource
import model.Game
import model.mapToGame

class GamesRepositoryImpl(
    private val remoteDataSource: KtorGamesDataSource,
    private val localDataSource: SqlDelightGamesDataSource
) : GamesRepository {

    override suspend fun fetchAllGames(): List<Game> {
        return listOf(remoteDataSource.fetchAllGames().mapToGame() )
    }

    override suspend fun searchGame(query: String): Game {
        return remoteDataSource.searchGame(query)
    }
}
