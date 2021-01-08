class Selection:

    def sort(a):
        # method alias
        less = Selection.__less
        exch = Selection.__exch

        n = len(a)
        for i in range(n):
            min = i
            for j in range(i + 1, n):
                if less(a[j], a[min]):
                    min = j
            # a[i], a[min] = a[min], a[i]
            exch(a, i, min)

    def __exch(a, v, w):
        a[v], a[w] = a[w], a[v]

    def __less(v, w):
        return v < w
