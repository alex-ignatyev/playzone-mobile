import SwiftUI
import SharedSDK

struct LoginScreen: View {
    
    @State private var isForgotPresented = false
    @State private var isRegistrationPresented = false
    @State private var isMainPresented = false
    private let viewModel = LoginViewModel()
    
    var body: some View {
        ObservingView(statePublisher: statePublisher(viewModel.viewStates())) { viewState in
            LoginView(viewState: viewState) { event in
                viewModel.obtainEvent(viewEvent: event)
            }
        }.sheet(isPresented: $isForgotPresented, content: {
            ForgotScreen()
        })
        .sheet(isPresented: $isRegistrationPresented, content: {
            RegistrationScreen().background(Color.primaryBackground)
        })
        .fullScreenCover(isPresented: $isMainPresented, content: {
            MainScreen()
        })
        .onReceive(sharePublisher(viewModel.viewActions())) { action in
            switch (action) {
            case is LoginActionOpenForgotScreen:
                isForgotPresented = true
                
            case is LoginActionOpenRegistrationScreen:
                isRegistrationPresented = true
                
            case is LoginActionOpenMainFlow:
                isMainPresented = true
                
            default:
                break
            }
        }
    }
}
