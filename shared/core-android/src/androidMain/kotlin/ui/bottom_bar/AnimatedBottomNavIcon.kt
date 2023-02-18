package ui.bottom_bar

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun AnimatedBottomNavIcon(
    imageVector: ImageVector,
    color: Color,
    modifier: Modifier = Modifier,
    scale: Float = 1f,
    animationDuration: Int = 500
) {
    val animatedScale: Float by animateFloatAsState(
        targetValue = scale,
        animationSpec = TweenSpec(
            durationMillis = animationDuration,
            easing = FastOutSlowInEasing
        )
    )
    val animatedColor by animateColorAsState(
        targetValue = color,
        animationSpec = TweenSpec(
            durationMillis = animationDuration,
            easing = FastOutSlowInEasing
        )
    )

    Icon(
        imageVector = imageVector,
        contentDescription = null,
        tint = animatedColor,
        modifier = modifier.scale(animatedScale)
    )
}
