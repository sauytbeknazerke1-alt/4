class Stack:
    def __init__(self):
        self.stack = []

    def push(self, x):
        self.stack.append(x)

    def pop(self):
        if not self.is_empty():
            return self.stack.pop()

    def display(self):
        print(self.stack)

    def clear(self):
        self.stack = []

    def is_empty(self):
        return len(self.stack) == 0

    def remove_less_than_avg(self):
        avg = sum(self.stack) / len(self.stack)
        self.stack = [x for x in self.stack if x >= avg]