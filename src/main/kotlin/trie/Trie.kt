package trie

class Trie<Key> {

    private val root = TrieNode<Key>(key = null, parent = null)

    fun insert(list: List<Key>) {
        // 1
        var current = root
        // 2
        list.forEach { element ->
            if (current.children[element] == null) {
                current.children[element] = TrieNode(element, current)
            }
            current = current.children[element]!!
        }
        // 3
        current.isTerminating = true
    }

    fun contains(list: List<Key>): Boolean {
        var current = root
        list.forEach { element ->
            val child = current.children[element] ?: return false
            current = child
        }
        return current.isTerminating
    }

    fun remove(collection: CollectionType) {
        // 1
        var current = root
        collection.forEach {
            val child = current.children[it] ?: return
            current = child
        }
        if (!current.isTerminating) return
// 2
        current.isTerminating = false
        // 3
        val parent = current.parent
        while (current.children.isEmpty() && !current.isTerminating) {
            parent?.let {
                it.children[current.key] = null
                current = it
            }
        }
    }

}