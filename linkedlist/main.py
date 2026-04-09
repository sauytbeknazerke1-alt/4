class ListNode:
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None

    def add_begin(self, data):
        new = ListNode(data)
        new.next = self.head
        self.head = new

    def add_end(self, data):
        new = ListNode(data)
        if not self.head:
            self.head = new
            return
        temp = self.head
        while temp.next:
            temp = temp.next
        temp.next = new

    def remove_last(self):
        if not self.head:
            return
        if not self.head.next:
            self.head = None
            return
        temp = self.head
        while temp.next.next:
            temp = temp.next
        temp.next = None

    def print_list(self):
        temp = self.head
        while temp:
            print(temp.data, end=" -> ")
            temp = temp.next
        print("None")

    def search(self, key):
        temp = self.head
        while temp:
            if temp.data == key:
                return True
            temp = temp.next
        return False

    def insert_pos(self, pos, data):
        new = ListNode(data)
        if pos == 0:
            self.add_begin(data)
            return
        temp = self.head
        for _ in range(pos - 1):
            temp = temp.next
        new.next = temp.next
        temp.next = new

    def remove_value(self, value):
        temp = self.head
        if temp and temp.data == value:
            self.head = temp.next
            return
        while temp.next:
            if temp.next.data == value:
                temp.next = temp.next.next
                return
            temp = temp.next

    def reverse(self):
        prev = None
        curr = self.head
        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
        self.head = prev

    def sort(self):
        if not self.head:
            return
        current = self.head
        while current:
            index = current.next
            while index:
                if current.data > index.data:
                    current.data, index.data = index.data, current.data
                index = index.next
            current = current.next

    def combine(self, other):
        if not self.head:
            self.head = other.head
            return
        temp = self.head
        while temp.next:
            temp = temp.next
        temp.next = other.head