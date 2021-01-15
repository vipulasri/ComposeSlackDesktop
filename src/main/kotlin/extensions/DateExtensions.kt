package extensions

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun Long.formatCreatedDate(): String {
    val date = LocalDateTime.ofInstant(Instant.ofEpochMilli(this), ZoneId.systemDefault())
    val formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy")
    return date.format(formatter)
}

fun Long.formatTime(): String {
    val date = LocalDateTime.ofInstant(Instant.ofEpochMilli(this), ZoneId.systemDefault())
    val formatter = DateTimeFormatter.ofPattern("hh:mm a")
    return date.format(formatter)
}