import SwiftUI
import SharedSDK

struct RegistrationView: View {
    
    let viewState: RegistrationState
    let eventHandler: (RegistrationEvent) -> Void
    
    var body: some View {
        VStack {
            VStack {
                Text("Create an Account")
                    .foregroundColor(.primaryTextColor)
                    .fontWeight(.bold)
                    .font(.system(size: 24))
                    .padding(EdgeInsets(top: 36, leading: 0, bottom: 50, trailing: 0))
                
                CommonTextField(hint: "Login", enabled: !viewState.isLoading) { newValue in
                    eventHandler(RegistrationEventLoginChanged(value: newValue))
                }.padding(.bottom, 24)
                
                CommonTextField(hint: "Password", enabled: !viewState.isLoading, isSecure: true) {newValue in
                    eventHandler(RegistrationEventPasswordChanged(value: newValue))
                }.padding(.bottom, 24)
                
                CommonTextField(hint: "Repeat password", enabled: !viewState.isLoading, isSecure: true) {newValue in
                    eventHandler(RegistrationEventPasswordRepeatChanged(value: newValue))
                }.padding(.bottom, 24)
                
                ActionButton(title: "Create Account", enabled: true) {
                    eventHandler(RegistrationEventCreateAccountClick())
                }.frame(height: 56)
            }
            
            Spacer()
        }
    }
}
