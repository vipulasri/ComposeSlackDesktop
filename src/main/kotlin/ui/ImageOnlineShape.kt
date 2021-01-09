package ui

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp

class ImageOnlineShape(val radius: Dp) : Shape {
    override fun createOutline(size: Size, density: Density): Outline {
        val path = Path().apply {
            arcTo(
                getTopLeftCorner(),
                180.0f, 90.0f, false
            )
            lineTo(size.width - radius.value, 0f)
            arcTo(
                getTopRightCorner(size),
                -90.0f, 90.0f, false
            )
            lineTo(size.width, size.height - radius.value)
            arcTo(
                getBottomRightCorner(size),
                270.0f, -90.0f, false
            )
            lineTo(0f, size.height)
            arcTo(
                getBottomLeftCorner(size),
                90.0f, 90.0f, false
            )
            close()
        }
        return Outline.Generic(path)
    }

    private fun getTopLeftCorner(): Rect {
        return Rect(0f, 0f, (radius.value * 2), (radius.value * 2))
    }

    private fun getTopRightCorner(size: Size): Rect {
        return Rect(size.width - (radius.value * 2), 0f, size.width, (radius.value * 2))
    }

    private fun getBottomLeftCorner(size: Size): Rect {
        return Rect(0f, size.width - (radius.value * 2), radius.value * 2, size.height)
    }

    private fun getBottomRightCorner(size: Size): Rect {
        return Rect(
            size.width - (radius.value * 2.2f),
            size.height - (radius.value * 2.2f),
            size.width + (radius.value * 2.5f),
            size.height + (radius.value * 2.5f)
        )
    }
}