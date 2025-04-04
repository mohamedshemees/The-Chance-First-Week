package thechance.suduko

import kotlin.math.sqrt

fun isValidSuduko(sudukoMatrix: Array<CharArray>): Boolean {
    if (sudukoMatrix.size != sudukoMatrix[0].size) return false
    for (row in sudukoMatrix) {
        for (input in row) {
            if (!isValidInput(input, sudukoMatrix.size)) {
                return false
            }
        }
    }

    for (row in sudukoMatrix) {
        if (!isValidRow(row)) {
            return false
        }
    }
    if (!areValidColumns(sudukoMatrix)) return false
    if (!isValidSubGrid(sudukoMatrix)) return false

    return true
}

fun isValidInput(input: Char, size: Int): Boolean {
    return when {
        input == '-' -> true
        size <= 9 -> input.isDigit() && input.digitToInt() in 1..size
        else -> (input.isDigit() && input.digitToInt() in 1..9) ||
                (input in 'A'..'G' && (10 + (input - 'A')) <= size)
    }
}
fun isValidSubGrid(sudokuMatrix: Array<CharArray>): Boolean {
    val subGridSize = sqrt(sudokuMatrix.size.toDouble()).toInt()
    for (windowRow in 0..<subGridSize) {
        for (windowCol in 0..<subGridSize) {
            val seen = mutableSetOf<Char>()
            for (i in windowRow * subGridSize..<(windowRow + 1) * subGridSize) {
                for (j in windowCol * subGridSize..<(windowCol + 1) * subGridSize) {
                    val current = sudokuMatrix[i][j]
                    if (current == '-') continue
                    if (current in seen) {
                        return false
                    }
                    seen.add(current)
                }
            }
        }
    }
    return true
}

fun isValidRow(row: CharArray): Boolean {
    val hashSet = HashSet<Char>()
    for (n in row) {
        if (n in hashSet && n!='-') {
            return false
        }
        hashSet.add(n)
    }
    return true
}

fun areValidColumns(sudukoMatrix: Array<CharArray>): Boolean {
    for (columnIndex in sudukoMatrix.indices) {
        val column = HashSet<Char>()
        for (rowIndex in sudukoMatrix.indices) {
            val current = sudukoMatrix[rowIndex][columnIndex]
            if (current in column && current!='-') {
                return false
            }
            column.add(current)
        }
    }
    return true
}