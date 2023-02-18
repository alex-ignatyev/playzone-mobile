import SwiftUI
import SharedSDK

struct MainView: View {
    
    var body: some View {
        TabView {
            HomeScreen()
                .tabItem {
                    Label("Home", systemImage: "house")
                }
            
            ProfileScreen()
                .tabItem {
                    Label("Profile", systemImage: "person")
                }
        }
    }
}
