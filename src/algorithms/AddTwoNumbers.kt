package algorithms

/**
 * Solution to the "Add 2 numbers" problem on LeetCode.
 *
 * Link to the problem: https://leetcode.com/problems/add-two-numbers/
 *
 * This solution contains 2 methods:
 * `fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode?` resolves the main problem
 * `fun addTwoNumbersNonReversed(l1: ListNode, l2: ListNode): ListNode?` resolves the follow-up problem
 */

fun main() {
    val list1 = ListNode(2, ListNode(4, ListNode(3)))
    val list2 = ListNode(5, ListNode(6, ListNode(4)))

    val addTwoNumbers = AddTwoNumbers()

    println(addTwoNumbers.addTwoNumbers(list1, list2)?.getString())
    println(addTwoNumbers.addTwoNumbersNonReversed(list1, list2)?.getString())
}

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode? {
        var ln1: ListNode? = l1
        var ln2: ListNode? = l2
        var carry = 0

        val listNode: ListNode = ListNode(0)
        var currentListNode: ListNode = listNode

        while (ln1 != null || ln2 != null || carry != 0) {
            val sum = ((ln1?.`val` ?: 0) + (ln2?.`val` ?: 0) + carry)

            currentListNode.next = ListNode(sum % 10)
            currentListNode = currentListNode.next!!

            ln1 = ln1?.next
            ln2 = ln2?.next
            carry = if (sum >= 10) 1 else 0
        }

        return listNode.next
    }

    fun addTwoNumbersNonReversed(l1: ListNode, l2: ListNode): ListNode? {
        var ln1: ListNode? = l1
        var ln2: ListNode? = l2
        var carry = 0

        var listNode: ListNode? = null
        var currentListNode: ListNode? = null

        while (ln1 != null || ln2 != null || carry != 0) {
            val sum = ((ln1?.`val` ?: 0) + (ln2?.`val` ?: 0) + carry)

            currentListNode = ListNode(sum % 10)
            currentListNode.next = listNode
            listNode = currentListNode

            ln1 = ln1?.next
            ln2 = ln2?.next
            carry = if (sum >= 10) 1 else 0
        }

        return listNode!!
    }
}


// Not related to solution
class ListNode(var `val`: Int) {
    var next: ListNode? = null

    constructor(value: Int, next: ListNode? = null): this(value) {
        this.next = next
    }

    fun getString(): String {
        var current: ListNode? = this
        var str = ""
        while (current != null) {
            str += current.`val`
            current = current.next
        }

        return str
    }
}