from sorted import knuth_shuffle as shuffle


class Quick3:

    def sort(a):
        # method alias
        sortR = Quick3.__sortRecursive

        shuffle(a)
        sortR(a, 0, len(a) - 1)

    def __sortRecursive(a, lo, hi):
        # method alias
        sortR = Quick3.__sortRecursive
        compareTo = Quick3.__compareTo
        exch = Quick3.__exch

        if hi <= lo:
            return

        lt = lo
        gt = hi
        v = a[lo]
        i = lo

        while i <= gt:
            cmp = compareTo(a[i], v)
            # print(a[i],v,cmp)
            if cmp < 0:
                exch(a, lt, i)
                lt += 1
                i += 1
            elif cmp > 0:
                exch(a, i, gt)
                gt -= 1
            else:
                i += 1

        sortR(a, lo, lt - 1)
        sortR(a, gt + 1, hi)

    def __exch(a, v, w):
        a[v], a[w] = a[w], a[v]

    def __compareTo(v, w):
        if v < w:
            return -1
        if v > w:
            return 1
        else:
            return 0
