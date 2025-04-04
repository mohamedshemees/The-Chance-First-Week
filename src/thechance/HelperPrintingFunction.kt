package thechance


fun printHelper(testcasename: String, result: Boolean, correctresult: Boolean): String {
    return if (result == correctresult) {
        ("Success - $testcasename  Correct Result is $correctresult returned $result")
    } else {
        ("Failed - $testcasename  Correct Result is $correctresult returned $result\"")
    }
}