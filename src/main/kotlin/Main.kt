import linkedlist.LinkedList

fun main(args: Array<String>) {
//    "creating and linking nodes" example
    val list = LinkedList<Int>()
    list.push(3).push(2).push(1)

//    println("Before inserting: $list")
//    val insertNodeAt = list.nodeAt(2)!!
//    list.insert(9, insertNodeAt)
//    println("After inserting: $list")

    println("Before popping list: $list")
    val poppedValue = list.pop()
    println("After popping list: $list")
    println("Popped value: $poppedValue")
}

class Car(var doors: Int)

fun printCar(car: Car?) {
//    val isCoupe = car?.let {
//        (it.doors <= 2)
//    }
    val isCoupe = car?.run { (doors <= 2) }
    println("isCoupe is $isCoupe")
    if (isCoupe == true) {
        println("Coupes are awesome")
    }
}

fun multiplicationBoard(size: Int) {
    for (number in 1..size) {
        print(" | ")
        for (otherNumber in 1..size) {
            print("$number x $otherNumber = ${number * otherNumber} |")
        }
        println()
    }
}