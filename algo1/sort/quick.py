from sorted import knuth_shuffle as shuffle


class Quick:

    def sort(a):
        # method alias
        sortR = Quick.__sortRecursive

        shuffle(a)
        sortR(a, 0, len(a) - 1)

    def __sortRecursive(a, lo, hi):
        # method alias
        sortR = Quick.__sortRecursive
        partition = Quick.__partition

        if hi <= lo:
            return
        j = partition(a, lo, hi)
        sortR(a, lo, j - 1)
        sortR(a, j + 1, hi)

    def __partition(a, lo, hi):
        # method alias
        less = Quick.__less
        exch = Quick.__exch

        i = lo
        j = hi + 1
        while True:
            i += 1
            while less(a[i], a[lo]):
                # i += 1
                if i == hi:
                    break
                i += 1
            j -= 1
            while less(a[lo], a[j]):
                # j -= 1
                if j == lo:
                    break
                j -= 1

            if i >= j:
                break
            exch(a, i, j)
        exch(a, lo, j)
        return j

    def __exch(a, v, w):
        a[v], a[w] = a[w], a[v]

    def __less(v, w):
        return v < w
