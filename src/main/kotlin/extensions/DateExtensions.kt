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

fun compareDates(dateMillis1: Long, dateMillis2: Long): Boolean {
    val date1 = LocalDateTime.ofInstant(Instant.ofEpochMilli(dateMillis1), ZoneId.systemDefault())
    val date2 = LocalDateTime.ofInstant(Instant.ofEpochMilli(dateMillis2), ZoneId.systemDefault())
    val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    return date1.format(formatter) != date2.format(formatter)
}