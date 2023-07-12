import tree.TreeNode
import trie.Trie

fun main(args: Array<String>) {
//    "creating and linking nodes" example
//    val list = LinkedList<Int>()
//    list.push(3).push(2).push(1)
//
//    println("Before inserting: $list")
//    val insertNodeAt = list.nodeAt(2)!!
//    list.insert(9, insertNodeAt)
//    println("After inserting: $list")
//
//    println("Before popping list: $list")
//    val poppedValue = list.pop()
//    println("After popping list: $list")
//    println("Popped value: $poppedValue")

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

//    val queue = StackQueue<String>().apply {
//        enqueue("Ray")
//        enqueue("Brian")
//        enqueue("Eric")
//    }
//    println(queue)
//    queue.dequeue()
//    println(queue)
//    queue.enqueue("Lennox")
//    println(queue)
//    println("Next up: ${queue.peek()}")
//    queue.dequeue()
//    println(queue)

//    val tree = makeBeverageTree()
//    tree.forEachDepthFirst { println(it.value) }

//    val tree = makeBeverageTree()
//    tree.forEachLevelOrder { println(it.value) }

//    tree.search("WKD Blue")?.let { println(it.value) }
//        ?: println("Couldn't find WKD Blue")

    // --------------------------------
//    val zero = BinaryNode(0)
//    val one = BinaryNode(1)
//    val five = BinaryNode(5)
//    val seven = BinaryNode(7)
//    val eight = BinaryNode(8)
//    val nine = BinaryNode(9)
//    seven.leftChild = one
//    one.leftChild = zero
//    one.rightChild = five
//    seven.rightChild = nine
//    nine.leftChild = eight
//    val tree = seven
//    println(tree)
//    tree.traverseInOrder { println(it) }
//    tree.traversePreOrder { println(it) }
//    tree.traversePostOrder { println(it) }

//    val bst = BinarySearchTree<Int>()
//    (0..4).forEach {
//        bst.insert(it)
//    }
//    println(bst)
//
//    val exampleTree = BinarySearchTree<Int>().apply {
//        insert(3)
//        insert(1)
//        insert(4)
//        insert(0)
//        insert(2)
//        insert(5)
//    }
//
//    println(exampleTree)

    val trie = Trie<Char>()
    trie.insert("cute".toList())
    if (trie.contains("cute".toList())) {
        println("cute is in the trie")
    }

}


fun makeBeverageTree(): TreeNode<String> {
    val tree = TreeNode("Beverages")
    val hot = TreeNode("hot")
    val cold = TreeNode("cold")
    val tea = TreeNode("tea")
    val coffee = TreeNode("coffee")
    val chocolate = TreeNode("cocoa")
    val blackTea = TreeNode("black")
    val greenTea = TreeNode("green")
    val chaiTea = TreeNode("chai")
    val soda = TreeNode("soda")
    val milk = TreeNode("milk")
    val gingerAle = TreeNode("ginger ale")
    val bitterLemon = TreeNode("bitter lemon")
    tree.add(hot)
    tree.add(cold)
    hot.add(tea)
    hot.add(coffee)
    hot.add(chocolate)
    cold.add(soda)
    cold.add(milk)
    tea.add(blackTea)
    tea.add(greenTea)
    tea.add(chaiTea)
    soda.add(gingerAle)
    soda.add(bitterLemon)
    return tree
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