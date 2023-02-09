import SwiftUI
import SharedSDK

struct ForgotScreen: View {
    
    @Environment(\.presentationMode) var presentationMode
    private let viewModel = ForgotViewModel()
    
    var body: some View {
        ObservingView(statePublisher: statePublisher(viewModel.viewStates())) { viewState in
            ForgotView(viewState: viewState) { event in
                viewModel.obtainEvent(viewEvent: event)
            }
        }.onReceive(sharePublisher(viewModel.viewActions())) { action in
            switch (action) {
            case is ForgotActionOpenLoginScreen:
                presentationMode.wrappedValue.dismiss()
                
            default:
                break
            }
        }
    }
}
