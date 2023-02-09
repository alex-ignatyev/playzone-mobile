import SwiftUI
import SharedSDK

struct ForgotView: View {
    
    let viewState: ForgotState
    let eventHandler: (ForgotEvent) -> Void
    
    var body: some View {
        VStack {
            VStack {
                Text("Forgot Password")
                    .foregroundColor(.primaryTextColor)
                    .fontWeight(.bold)
                    .font(.system(size: 24))
                    .padding(.top, 36)
                
                Text("Enter right Login and change your password")
                    .foregroundColor(.primaryTextColor.opacity(0.5))
                    .fixedSize(horizontal: false, vertical: true)
                    .multilineTextAlignment(.center)
                    .padding(EdgeInsets(top: 16, leading: 30, bottom: 50, trailing: 30))
                
                CommonTextField(hint: "Login", enabled: !viewState.isLoading) { newValue in
                    eventHandler(ForgotEventLoginChanged(value: newValue))
                }.padding(.bottom, 24)
                
                CommonTextField(hint: "New password", enabled: !viewState.isLoading, isSecure: true) {newValue in
                    eventHandler(ForgotEventPasswordChanged(value: newValue))
                }.padding(.bottom, 24)
                
                CommonTextField(hint: "Repeat new password", enabled: !viewState.isLoading, isSecure: true) {newValue in
                    eventHandler(ForgotEventPasswordRepeatChanged(value: newValue))
                }.padding(.bottom, 24)
                
                ActionButton(title: "Change Password", enabled: true) {
                    eventHandler(ForgotEventChangePasswordClick())
                }.frame(height: 56)
            }
            
            Spacer()
        }
    }
}
