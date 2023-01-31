import db.databaseModule
import ktor.ktoreModule
import org.kodein.di.DI

val coreModule = DI.Module("coreModule") {
    importAll(
        ktoreModule,
        databaseModule
    )
}
