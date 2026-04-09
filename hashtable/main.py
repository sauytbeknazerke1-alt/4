class HashTable:
    def __init__(self, size=10):
        self.size = size
        self.table = [[] for _ in range(size)]

    def hash(self, key):
        return key % self.size

    def insert(self, key):
        index = self.hash(key)
        self.table[index].append(key)

    def remove(self, key):
        index = self.hash(key)
        if key in self.table[index]:
            self.table[index].remove(key)

    def display(self):
        print(self.table)

    def sum_elements(self):
        return sum(sum(bucket) for bucket in self.table)

    def find_min_max(self):
        elements = [x for bucket in self.table for x in bucket]
        return min(elements), max(elements)

    def even_odd(self):
        elements = [x for bucket in self.table for x in bucket]
        even = [x for x in elements if x % 2 == 0]
        odd = [x for x in elements if x % 2 != 0]
        return even, odd