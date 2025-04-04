package thechance.ipv4

import thechance.printHelper


fun main() {
//region Empty or Blank ipV4
    println(
        printHelper(
            testcasename = "Invalid IpV4 Empty String",
            result = isValidIp(""),
            correctresult = false
        )
    )
    println(
        printHelper(
            testcasename = "Invalid IpV4 Blank String",
            result = isValidIp(" "),
            correctresult = false
        )
    )
//endregion
//region Invalid IpV4 Missing Segment
    println(
        printHelper(
            testcasename = "Invalid IpV4 Missing Segment",
            result = isValidIp("192.2.146"),
            correctresult = false
        )
    )
//endregion
// region Invalid IpV4 Empty Segment
    println(
        printHelper(
            testcasename = "Invalid IpV4 Empty Segment",
            result = isValidIp("192.122..256"),
            correctresult = false
        )
    )
    //endregion
//region Invalid IpV4 Empty Segment
    println(
        printHelper(
            testcasename = "Invalid IpV4 Empty Segment",
            result = isValidIp("192.122. .256"),
            correctresult = false
        )
    )
//endregion
//region Invalid IpV4  Segment With Leading Zero
    println(
        printHelper(
            testcasename = "Invalid IpV4 Segment With Leading Zero",
            result = isValidIp("092.00.2.146"),
            correctresult = false
        )
    )
//endregion
//region Invalid IpV4  Segment Out Of Bound
    println(
        printHelper(
            testcasename = "Invalid IpV4 Segment Out Of Bound",
            result = isValidIp("192.122.129.256"),
            correctresult = false
        )
    )
//endregion
//region Invalid IpV4 More than 4 Segments
    println(
        printHelper(
            testcasename = "Invalid IpV4 More than 4 Segments ",
            result = isValidIp("192.122.129.2.32"),
            correctresult = false
        )
    )
//endregion
//region valid IpV4
    println(
        printHelper(
            testcasename = "Valid IpV4",
            result = isValidIp("192.123.43.0"),
            correctresult = true
        )
    )

    println(
        printHelper(
            testcasename = "Valid IpV4",
            result = isValidIp("192.0.2.146"),
            correctresult = true
        )
    )
    println(
        printHelper(
            testcasename = "Valid IpV4",
            result = isValidIp("10.20.2.146"),
            correctresult = true
        )
    )
    //endregion
}


