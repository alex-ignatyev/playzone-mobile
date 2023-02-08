//
//  Color + Customs.swift
//  iosApp
//
//  Created by Алексей on 08.02.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import SwiftUI

extension Color {
    
    static let textPrimary = Color("textPrimary")
    static let secondaryBackground = Color("secondaryBackground")
    static let secondaryTextColor = Color("secondaryTextColor")
    static let tintColor = Color("tintColor")
    static let actionTextColor = Color("actionTextColor")
    static let primaryBackground = Color("primaryBackground")
    
    init(hex: UInt, alpha: Double = 1) {
        self.init(
            .sRGB, 
            red: Double((hex >> 16) & 0xff) / 255,
            green: Double((hex >> 08) & 0xff) / 255,
            blue: Double((hex >> 00) & 0xff) / 255,
           opacity: alpha
        )
    }
}
