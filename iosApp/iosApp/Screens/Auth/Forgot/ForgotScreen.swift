import SwiftUI
import SharedSDK

struct ForgotScreen: View {
    
    @State private var isLoginPresented = false
    private let viewModel = ForgotViewModel()
    
    var body: some View {
        ObservingView(statePublisher: statePublisher(viewModel.viewStates())) { viewState in
            ForgotView(viewState: viewState) { event in
                viewModel.obtainEvent(viewEvent: event)
            }
        }.sheet(isPresented: $isLoginPresented, content: {
            
        })
        .onReceive(sharePublisher(viewModel.viewActions())) { action in
            switch (action) {
            case is ForgotActionOpenLoginScreen:
                isLoginPresented = true
                
            default:
                break
            }
        }
    }
}
