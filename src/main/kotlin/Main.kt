import linkedlist.LinkedList
import queue.ArrayListQueue
import stack.StackImpl

fun main(args: Array<String>) {
//    "creating and linking nodes" example
    val list = LinkedList<Int>()
    list.push(3).push(2).push(1)

    println("Before inserting: $list")
    val insertNodeAt = list.nodeAt(2)!!
    list.insert(9, insertNodeAt)
    println("After inserting: $list")

    println("Before popping list: $list")
    val poppedValue = list.pop()
    println("After popping list: $list")
    println("Popped value: $poppedValue")

//    val list = LinkedList<Int>()
//    list.push(3)
//    list.push(2)
//    list.push(1)
//    println(list)
//    for (item in list) {
//        println("Double: ${item * 2}")
//    }

    //Stack
//    val stack = StackImpl<Int>().apply {
//        push(1)
//        push(2)
//        push(3)
//        push(4)
//    }
//    print(stack)
//    val poppedElement = stack.pop()
//    if (poppedElement != null) {
//        println("Popped: $poppedElement")
//    }
//    print(stack)

    //ArrayListQueue
//    val queue = ArrayListQueue<String>().apply {
//        enqueue("Ray")
//        enqueue("Brian")
//        enqueue("Eric")
//    }
//    println(queue)
//    queue.dequeue()
//    println(queue)
//    println("Next up: ${queue.peek()}")
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