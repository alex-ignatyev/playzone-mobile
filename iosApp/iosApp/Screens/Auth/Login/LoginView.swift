import SwiftUI
import SharedSDK

struct LoginView: View {
    
    let viewState: LoginState
    let eventHandler: (LoginEvent) -> Void
    
    var body: some View {
        VStack {
            VStack {
                Spacer().frame(height: 36)
                Text("Login Now")
                    .foregroundColor(.primaryTextColor)
                    .fontWeight(.bold)
                    .font(.system(size: 24))
                
                Text("Welcome back! Enter your email addres and your password to enjoy the latest features")
                    .foregroundColor(.primaryTextColor.opacity(0.5))
                    .fixedSize(horizontal: false, vertical: true)
                    .multilineTextAlignment(.center)
                    .padding(EdgeInsets(top: 16, leading: 30, bottom: 0, trailing: 30))
                
                Spacer().frame(height: 50)
                
                CommonTextField(hint: "Login", enabled: !viewState.isLoading) { newValue in
                    eventHandler(LoginEventLoginChanged(value: newValue))
                }
                
                Spacer().frame(height: 24)
                
                CommonTextField(hint: "Password", enabled: !viewState.isLoading, isSecure: !viewState.passwordHidden) {newValue in
                    eventHandler(LoginEventPasswordChanged(value: newValue))
                }
            }
            
            LoginActionView(
                onForgotClick: {
                    eventHandler(LoginEventForgotClick())
                },
                onLoginClick: {
                    eventHandler(LoginEventLoginClick())
                })
            
            Spacer()
            
            HStack {
                Text("Don't have accont ?")
                    .foregroundColor(.primaryTextColor)
                    .opacity(0.5)
                
                Text("Create one")
                    .foregroundColor(.tintColor)
                    .fontWeight(.bold)
                    .onTapGesture {
                        eventHandler(LoginEventRegistrationClick())
                    }
            }
        }
    }
}

struct LoginActionView: View {
    
    let onForgotClick: () -> Void
    let onLoginClick: () -> Void
    
    var body: some View {
        VStack {
            Spacer().frame(height: 30)
            HStack {
                Spacer()
                Text("Forgot Password")
                    .foregroundColor(.tintColor)
                    .onTapGesture {
                        onForgotClick()
                    }
                Spacer().frame(width: 30)
            }
            
            Spacer().frame(height: 30)
            
            ActionButton(title: "Login Now", enabled: true) {
                onLoginClick()
            }.frame(height: 56)
        }
    }
}
