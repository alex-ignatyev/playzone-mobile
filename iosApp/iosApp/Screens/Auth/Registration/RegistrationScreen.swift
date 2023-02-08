import SwiftUI
import SharedSDK

struct RegistrationScreen: View {
    
    @State private var isLoginPresented = false
    @Environment(\.presentationMode) var presentationMode
    private let viewModel = RegistrationViewModel()
    
    var body: some View {
        ObservingView(statePublisher: statePublisher(viewModel.viewStates())) { viewState in
            RegistrationView(viewState: viewState) { event in
                viewModel.obtainEvent(viewEvent: event)
            }
        }
        .onReceive(sharePublisher(viewModel.viewActions())) { action in
            switch (action) {
            case is RegistrationActionOnSuccessScreen:
                presentationMode.wrappedValue.dismiss()
                
            default:
                break
            }
        }
    }
}
