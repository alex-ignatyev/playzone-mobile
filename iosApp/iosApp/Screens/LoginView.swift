import SwiftUI
import SharedSDK

struct LoginView: View {
    
    var body: some View {
        VStack {
            VStack {
                Spacer().frame(height: 36)
                 Text("Login Now")
                    .foregroundColor(.textPrimary)
                     .fontWeight(.bold)
                      .font(.system(size: 24))
                
                Text("Welcome back! Enter your email addres and your password to enjoy the latest features")
                                    .foregroundColor(.textPrimary.opacity(0.5))
                                    .fixedSize(horizontal: false, vertical: true)
                                    .multilineTextAlignment(.center)
                                    .padding(EdgeInsets(top: 16, leading: 30, bottom: 0, trailing: 30))
                
                Spacer().frame(height: 50)
                
                CommonTextField(hint: "Login", enabled: false) { newValue in
                                   
                }
                
                Spacer().frame(height: 24)
                
                CommonTextField(hint: "Password", enabled: false, isSecure: false) {newValue in
                                    
                }
            }
            
            Spacer()
            
            HStack {
                
            }
        }
    }
}

struct LoginView_Previews: PreviewProvider {
    static var previews: some View {
        LoginView()
    }
}
