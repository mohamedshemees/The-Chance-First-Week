package thechance.suduko

import thechance.printHelper


/**
 * @author Mohamed Shemees
 */

fun main() {

//region Check if Matrix is a Square Matrix

    println(
        printHelper(
            testcasename = "Not A Square Matrix",
            result = isValidSuduko(
                arrayOf(
                    charArrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9'),
                    charArrayOf('4', '5', '6', '7', '8', '9'),  // Incomplete row
                    charArrayOf('7', '8', '9', '1', '2', '3', '4', '5', '6')
                )
            ),
            correctresult = false
        )
    )
//endregion

// region Check if Matrix Has Empty Cell (Valid Sudoku)
    println(
        printHelper(
            testcasename = "Has Empty Cell (Valid Sudoku)",
            result = isValidSuduko(
                arrayOf(
                    charArrayOf('5', '3', '-', '6', '7', '8', '9', '1', '2'),  // Empty at (0,2)
                    charArrayOf('6', '7', '2', '1', '9', '5', '3', '4', '8'),
                    charArrayOf('1', '9', '8', '3', '4', '2', '5', '6', '7'),
                    charArrayOf('8', '5', '9', '7', '6', '1', '4', '2', '3'),
                    charArrayOf('4', '2', '6', '8', '5', '3', '7', '9', '1'),
                    charArrayOf('7', '1', '3', '9', '2', '4', '8', '5', '6'),
                    charArrayOf('9', '6', '1', '5', '3', '7', '2', '8', '4'),
                    charArrayOf('2', '8', '7', '4', '1', '9', '6', '3', '5'),
                    charArrayOf('3', '4', '5', '2', '8', '6', '1', '7', '9')
                )
            ),
            correctresult = true  // Valid despite empty cells
        )
    )
//endregion
//region Check if Value Out Of Bound
    println(
        printHelper(
            testcasename = "Value Out Of Bound",
            result = isValidSuduko(
                arrayOf(
                    charArrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9'),
                    charArrayOf('4', '5', '6', '7', '8', '9', '1', '2', '3'),
                    charArrayOf('7', '8', '9', '1', '2', '3', '4', '5', '6'),
                    charArrayOf('2', '3', '4', '5', '6', '7', '8', '9', '1'),
                    charArrayOf('5', '6', '7', '8', '9', '1', '2', '3', 'A'),  // Invalid 'A'
                    charArrayOf('8', '9', '1', '2', '3', '4', '5', '6', '7'),
                    charArrayOf('3', '4', '5', '6', '7', '8', '9', '1', '2'),
                    charArrayOf('6', '7', '8', '9', '1', '2', '3', '4', '5'),
                    charArrayOf('9', '1', '2', '3', '4', '5', '6', '7', '8')
                )
            ),
            correctresult = false
        )
    )
//endregion
//region Check if Has Row Duplicates
    println(
        printHelper(
            testcasename = "Has Row Duplicates",
            result = isValidSuduko(
                arrayOf(
                    charArrayOf('1', '2', '3', '4', '5', '6', '3', '8', '9'),  // Duplicate '3'
                    charArrayOf('4', '5', '6', '7', '8', '9', '1', '2', '3'),
                    charArrayOf('7', '8', '9', '1', '2', '3', '4', '5', '6'),
                    charArrayOf('2', '3', '4', '5', '6', '7', '8', '9', '1'),
                    charArrayOf('5', '6', '7', '8', '9', '1', '2', '3', '4'),
                    charArrayOf('8', '9', '1', '2', '3', '4', '5', '6', '7'),
                    charArrayOf('3', '4', '5', '6', '7', '8', '9', '1', '2'),
                    charArrayOf('6', '7', '8', '9', '1', '2', '6', '4', '5'),  // Duplicate '6'
                    charArrayOf('9', '1', '2', '3', '4', '5', '7', '7', '8')    // Duplicate '7'
                )
            ),
            correctresult = false
        )
    )
//endregion
//region Check if Has Column Duplicates
    println(
        printHelper(
            testcasename = "Has Column Duplicates",
            result = isValidSuduko(
                arrayOf(
                    charArrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9'),
                    charArrayOf('4', '5', '6', '7', '8', '9', '1', '2', '3'),
                    charArrayOf('7', '8', '9', '1', '2', '3', '4', '5', '6'),
                    charArrayOf('2', '3', '4', '5', '6', '7', '8', '9', '1'),
                    charArrayOf('5', '6', '7', '8', '9', '1', '2', '3', '4'),
                    charArrayOf('8', '9', '1', '2', '3', '4', '5', '6', '7'),
                    charArrayOf('3', '4', '5', '6', '7', '8', '9', '1', '2'),
                    charArrayOf('6', '7', '8', '9', '1', '2', '3', '4', '5'),

                    charArrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9')    // Duplicate '1' in column 0
                )
            ),
            correctresult = false
        )
    )
//endregion
//region Check if   Subgrid Duplicate No Row Column Duplicates
    println(
        printHelper(
            testcasename = "Subgrid Duplicate No Row Column Duplicates",
            result = isValidSuduko(
                arrayOf(
                    charArrayOf('1', '2', '-', '4', '5', '6', '7', '8', '9'),
                    charArrayOf('-', '5', '6', '-', '8', '9', '1', '2', '3'),
                    charArrayOf('7', '8', '1', '1', '3', '4', '5', '6', '-'),
                    charArrayOf('2', '3', '4', '5', '6', '7', '8', '9', '1'),
                    charArrayOf('5', '6', '7', '8', '9', '1', '2', '3', '4'),
                    charArrayOf('8', '9', '2', '3', '4', '5', '6', '7', '8'),
                    charArrayOf('3', '4', '5', '6', '7', '8', '9', '1', '2'),
                    charArrayOf('6', '7', '8', '9', '1', '2', '3', '4', '5'),
                    charArrayOf('9', '1', '3', '2', '5', '6', '4', '-', '7')
                )
            ),
            correctresult = false
        )
    )
//endregion
//region Valid Sudoku (Complete)
    println(
        printHelper(
            testcasename = "Valid Sudoku (Complete)",
            result = isValidSuduko(
                arrayOf(
                    charArrayOf('5', '3', '4', '6', '7', '8', '9', '1', '2'),
                    charArrayOf('6', '7', '2', '1', '9', '5', '3', '4', '8'),
                    charArrayOf('1', '9', '8', '3', '4', '2', '5', '6', '7'),
                    charArrayOf('8', '5', '9', '7', '6', '1', '4', '2', '3'),
                    charArrayOf('4', '2', '6', '8', '5', '3', '7', '9', '1'),
                    charArrayOf('7', '1', '3', '9', '2', '4', '8', '5', '6'),
                    charArrayOf('9', '6', '1', '5', '3', '7', '2', '8', '4'),
                    charArrayOf('2', '8', '7', '4', '1', '9', '6', '3', '5'),
                    charArrayOf('3', '4', '5', '2', '8', '6', '1', '7', '9')
                )
            ),
            correctresult = true
        )
    )

//endregion
//region Valid Incomplete Sudoku
    println(
        printHelper(
            testcasename = "Valid Incomplete Sudoku",
            result = isValidSuduko(
                arrayOf(
                    charArrayOf('5', '3', '-', '6', '7', '-', '9', '1', '2'),
                    charArrayOf('6', '-', '2', '-', '9', '5', '3', '-', '8'),
                    charArrayOf('1', '9', '8', '3', '4', '2', '5', '6', '7'),
                    charArrayOf('-', '5', '9', '7', '-', '1', '4', '2', '3'),
                    charArrayOf('4', '-', '6', '8', '5', '3', '-', '9', '1'),
                    charArrayOf('7', '1', '-', '9', '2', '-', '8', '5', '6'),
                    charArrayOf('9', '-', '1', '5', '3', '7', '2', '-', '4'),
                    charArrayOf('2', '8', '7', '4', '-', '9', '6', '3', '-'),
                    charArrayOf('-', '4', '5', '-', '8', '6', '1', '7', '9')
                )
            ),
            correctresult = true
        )
    )
//endregion
//region Valid 4x4 Sudoku (Complete)
    println(
        printHelper(
            testcasename = "Valid 4x4 Sudoku (Complete)",
            result = isValidSuduko(
                arrayOf(
                    charArrayOf('1', '2', '3', '4'),
                    charArrayOf('3', '4', '1', '2'),
                    charArrayOf('2', '1', '4', '3'),
                    charArrayOf('4', '3', '2', '1')
                )
            ),
            correctresult = true
        )
    )
//endregion

//region Valid 4x4 Sudoku (Incomplete)
    println(
        printHelper(
            testcasename = "Valid 4x4 Sudoku (Incomplete)",
            result = isValidSuduko(
                arrayOf(
                    charArrayOf('1', '-', '-', '4'),
                    charArrayOf('-', '4', '1', '-'),
                    charArrayOf('2', '-', '-', '3'),
                    charArrayOf('-', '3', '2', '-')
                )
            ),
            correctresult = true
        )
    )
//endregion
//region  Invalid 4x4 Sudoku (Row Duplicate)
    println(
        printHelper(
            testcasename = "Invalid 4x4 Sudoku (Row Duplicate)",
            result = isValidSuduko(
                arrayOf(
                    charArrayOf('1', '2', '3', '3'), // Duplicate '3'
                    charArrayOf('3', '4', '1', '2'),
                    charArrayOf('2', '1', '4', '-'),
                    charArrayOf('4', '3', '2', '1')
                )
            ),
            correctresult = false
        )
    )

//endregion
    //region Valid 16x16 Sudoku (Complete)
 println(printHelper(
        testcasename = "Valid 16x16 Sudoku (Complete)",
        result = isValidSuduko(
            arrayOf(
                charArrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G'),
                charArrayOf('5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4'),
                charArrayOf('9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8'),
                charArrayOf('D', 'E', 'F', 'G', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C'),
                charArrayOf('2', '1', '4', '3', '6', '5', '8', '7', 'A', '9', 'C', 'B', 'E', 'D', 'G', 'F'),
                charArrayOf('6', '5', '8', '7', 'A', '9', 'C', 'B', 'E', 'D', 'G', 'F', '2', '1', '4', '3'),
                charArrayOf('A', '9', 'C', 'B', 'E', 'D', 'G', 'F', '2', '1', '4', '3', '6', '5', '8', '7'),
                charArrayOf('E', 'D', 'G', 'F', '2', '1', '4', '3', '6', '5', '8', '7', 'A', '9', 'C', 'B'),
                charArrayOf('3', '4', '1', '2', '7', '8', '5', '6', 'B', 'C', '9', 'A', 'F', 'G', 'D', 'E'),
                charArrayOf('7', '8', '5', '6', 'B', 'C', '9', 'A', 'F', 'G', 'D', 'E', '3', '4', '1', '2'),
                charArrayOf('B', 'C', '9', 'A', 'F', 'G', 'D', 'E', '3', '4', '1', '2', '7', '8', '5', '6'),
                charArrayOf('F', 'G', 'D', 'E', '3', '4', '1', '2', '7', '8', '5', '6', 'B', 'C', '9', 'A'),
                charArrayOf('4', '3', '2', '1', '8', '7', '6', '5', 'C', 'B', 'A', '9', 'G', 'F', 'E', 'D'),
                charArrayOf('8', '7', '6', '5', 'C', 'B', 'A', '9', 'G', 'F', 'E', 'D', '4', '3', '2', '1'),
                charArrayOf('C', 'B', 'A', '9', 'G', 'F', 'E', 'D', '4', '3', '2', '1', '8', '7', '6', '5'),
                charArrayOf('G', 'F', 'E', 'D', '4', '3', '2', '1', '8', '7', '6', '5', 'C', 'B', 'A', '9')
            )
        ),
        correctresult = true
    ))

    //endregion
}



