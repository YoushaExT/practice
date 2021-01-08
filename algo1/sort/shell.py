class Shell:

    def sort(a):
        # method alias
        less = Shell.__less
        exch = Shell.__exch

        n = len(a)

        h = 1
        # calculate biggest h
        while (h < n // 3):
            h = 3 * h + 1

        while (h >= 1):
            # h-sort the array
            for i in range(h, n):
                j = i
                while j >= h and less(a[j], a[j - h]):
                    exch(a, j, j - h)
                    j -= h
            h = h // 3

    def __exch(a, v, w):
        a[v], a[w] = a[w], a[v]

    def __less(v, w):
        return v < w
