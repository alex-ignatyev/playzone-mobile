import SwiftUI

struct ActionButton: View {
    
    let title: String
    var enabled: Bool = true
    let height: CGFloat = 56
    let horizontalMargin: CGFloat = 16
    let action: () -> Void
    
    var body: some View {
        ZStack {
            RoundedRectangle(cornerRadius: 10)
                .foregroundColor(.tintColor)
                .opacity(enabled ? 1.0 : 0.5)
            
            Text(title)
                .foregroundColor(.actionTextColor)
        }.frame(maxWidth: .infinity, minHeight: height)
            .padding(EdgeInsets(top: 0, leading: horizontalMargin, bottom: 0, trailing: horizontalMargin))
            .onTapGesture {
                action()
            }
    }
}