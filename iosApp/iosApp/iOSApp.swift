import SwiftUI
import SharedSDK

@main
struct iOSApp: App {
    
    init() {
        AndroidPlatformSDK().doInit(configuration: PlatformConfiguration())
    }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
