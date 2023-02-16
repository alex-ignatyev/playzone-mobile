import di.Inject
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.direct
import org.kodein.di.singleton
import platform.PlatformConfiguration

object AndroidPlatformSDK {

    fun init(
        configuration: PlatformConfiguration
    ) {
        val platformModule = DI.Module(
            name = "androidPlatformModule",
            init = {
                bind<PlatformConfiguration>() with singleton { configuration }
            }
        )

        Inject.createDependencies(
            DI {
                importAll(
                    coreModule,
                    authModule,
                    platformModule
                )
            }.direct
        )
    }
}
