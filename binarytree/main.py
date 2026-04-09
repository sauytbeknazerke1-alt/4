class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


class BinaryTree:
    def __init__(self):
        self.root = None


    def insert(self, value):
        if not self.root:
            self.root = Node(value)
            return

        current = self.root
        while True:
            if value < current.value:
                if current.left:
                    current = current.left
                else:
                    current.left = Node(value)
                    break
            else:
                if current.right:
                    current = current.right
                else:
                    current.right = Node(value)
                    break


    def display(self, node):
        if node:
            self.display(node.left)
            print(node.value, end=" ")
            self.display(node.right)

    def remove(self, node, value):
        if not node:
            return None

        if value < node.value:
            node.left = self.remove(node.left, value)
        elif value > node.value:
            node.right = self.remove(node.right, value)
        else:
            if not node.left:
                return node.right
            if not node.right:
                return node.left

            temp = node.right
            while temp.left:
                temp = temp.left
            node.value = temp.value
            node.right = self.remove(node.right, temp.value)

        return node


    def count_even_odd(self, node):
        if not node:
            return (0, 0)
        left = self.count_even_odd(node.left)
        right = self.count_even_odd(node.right)

        even = left[0] + right[0]
        odd = left[1] + right[1]

        if node.value % 2 == 0:
            even += 1
        else:
            odd += 1

        return (even, odd)


    def find_min(self):
        current = self.root
        while current.left:
            current = current.left
        return current.value

    def find_max(self):
        current = self.root
        while current.right:
            current = current.right
        return current.value


    def height(self, node):
        if not node:
            return 0
        return 1 + max(self.height(node.left), self.height(node.right))


    def is_empty(self):
        return self.root is None


    def delete_tree(self):
        self.root = None