package navigation.tabs

import Theme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabConfiguration
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabItem

class HomeTab : TabItem() {
    override val configuration: TabConfiguration
        @Composable
        get() {
            return TabConfiguration(
                title = "Home",
                selectedColor = Theme.colors.primaryAction,
                unselectedColor = Theme.colors.hintTextColor,
                titleStyle = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            )
        }
}

class ProfileTab : TabItem() {
    override val configuration: TabConfiguration
        @Composable
        get() {
            return TabConfiguration(
                title = "Profile",
                selectedColor = Theme.colors.primaryAction,
                unselectedColor = Theme.colors.hintTextColor,
                titleStyle = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            )
        }
}
