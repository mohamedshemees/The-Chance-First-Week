package thechance.ipv4

fun isValidIp(ip: String): Boolean {
    //Early Exiting
    if (ip.isBlank() || ip.isEmpty()) return false
    val ipSegments = ip.split('.')
    if (ipSegments.size != 4) {
        return false
    }
    for (segment in ipSegments) {
        if (segment.toIntOrNull() in 0..255) {
            if (segment.length > 1) {
                if (segment[0] == '0') return false
            }
        } else return false
    }

    return true
}