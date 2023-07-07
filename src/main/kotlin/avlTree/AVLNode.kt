package avlTree

import queue.StackQueue
import java.lang.Integer.max

typealias Visitor<T> = (AVLNode<T>) -> Unit

class AVLNode<T>(val value: T) {
    private val children: MutableList<AVLNode<T>> = mutableListOf()

    var height = 0

    val leftHeight: Int
        get() = leftChild?.height ?: -1

    val rightHeight: Int
        get() = rightChild?.height ?: -1

    val balanceFactor: Int
        get() = leftHeight - rightHeight

    fun add(child: AVLNode<T>) = children.add(child)

    fun forEachDepthFirst(visit: Visitor<T>) {
        visit(this)
        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }

    fun search(value: T): AVLNode<T>? {
        var result: AVLNode<T>? = null
        forEachLevelOrder {
            if (it.value == value) {
                result = it
            }
        }
        return result
    }

    fun forEachLevelOrder(visit: Visitor<T>) {
        visit(this)
        val queue = StackQueue<AVLNode<T>>()
        children.forEach { queue.enqueue(it) }
        var node = queue.dequeue()
        while (node != null) {
            visit(node)
            node.children.forEach { queue.enqueue(it) }
            node = queue.dequeue()
        }
    }

    private fun leftRotate(node: AVLNode<T>): AVLNode<T> {
        // 1
        val pivot = node.rightChild!!
        // 2
        node.rightChild = pivot.leftChild
        // 3
        pivot.leftChild = node
// 4
        node.height = max(node.leftHeight, node.rightHeight) + 1
        pivot.height = max(pivot.leftHeight, pivot.rightHeight) + 1
        // 5
        return pivot
    }

    private fun rightRotate(node: AVLNode<T>): AVLNode<T> {
        val pivot = node.leftChild!!
        node.leftChild = pivot.rightChild
        pivot.rightChild = node
        node.height = max(node.leftHeight, node.rightHeight) + 1
        pivot.height = max(pivot.leftHeight, pivot.rightHeight) + 1
        return pivot
    }

    private fun rightLeftRotate(node: AVLNode<T>): AVLNode<T> {
        val rightChild = node.rightChild ?: return node
        node.rightChild = rightRotate(rightChild)
        return leftRotate(node)
    }

    private fun leftRightRotate(node: AVLNode<T>): AVLNode<T> {
        val leftChild = node.leftChild ?: return node
        node.leftChild = rightRotate(leftChild)
        return rightRotate(node)
    }

    private fun balanced(node: AVLNode<T>): AVLNode<T> {
        return when (node.balanceFactor) {
            2 -> {
                if (node.leftChild?.balanceFactor == -1) {
                    leftRightRotate(node)
                } else {
                    rightRotate(node)
                }
            }
            -2 -> {
                if (node.rightChild?.balanceFactor == 1) {
                    rightLeftRotate(node)
                } else {
                    leftRotate(node)
                }
            }
            else -> node }
    }

    private fun insert(node: AVLNode<T>?, value: T): AVLNode<T>? {
        node ?: return AVLNode(value)
        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value)
        } else {
            node.rightChild = insert(node.rightChild, value)
        }
        val balancedNode = balanced(node)
        balancedNode?.height = max(balancedNode?.leftHeight ?: 0,
            balancedNode?.rightHeight ?: 0) + 1
        return balancedNode
    }

}