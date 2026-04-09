class Queue:
    def __init__(self):
        self.queue = []

    def enqueue(self, x):
        self.queue.append(x)

    def dequeue(self):
        if not self.is_empty():
            return self.queue.pop(0)

    def display(self):
        print(self.queue)

    def clear(self):
        self.queue = []

    def is_empty(self):
        return len(self.queue) == 0

    def remove_even(self):
        self.queue = [x for x in self.queue if x % 2 != 0]