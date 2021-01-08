class Insertion:

    def sort(a):
        # method alias
        less = Insertion.__less
        exch = Insertion.__exch

        n = len(a)
        for i in range(n):
            for j in range(i, 0, -1):
                if less(a[j], a[j-1]):
                    exch(a, j, j-1)
                else:
                    break

    def __exch(a, v, w):
        a[v], a[w] = a[w], a[v]

    def __less(v, w):
        return v < w
