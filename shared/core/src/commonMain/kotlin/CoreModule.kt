import db.databaseModule
import ktor.ktoreModule
import org.kodein.di.DI
import settings.settingsModule

val coreModule = DI.Module("coreModule") {
    importAll(
        ktoreModule,
        settingsModule,
        databaseModule
    )
}
