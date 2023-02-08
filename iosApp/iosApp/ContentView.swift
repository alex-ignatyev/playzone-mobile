import SwiftUI
import SharedSDK

struct ContentView: View {

	var body: some View {
        LoginScreen()
            .preferredColorScheme(.dark)
            .background(Color.primaryBackground)
            .background(ignoresSafeAreaEdges: [.top, .bottom])
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
