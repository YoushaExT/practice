class Merge:
    def sort(a):
        # method alias
        sortR = Merge.__sortRecursive

        aux = []
        sortR(a, aux, 0, len(a) - 1)

    def __sortRecursive(a, aux, lo, hi):
        # method alias
        sortR = Merge.__sortRecursive
        merge = Merge.__merge

        if hi <= lo:
            return
        mid = lo + (hi - lo) // 2
        sortR(a, aux, lo, mid)
        sortR(a, aux, mid + 1, hi)
        merge(a, aux, lo, mid, hi)

    def __merge(a, aux, lo, mid, hi):
        # method alias
        less = Merge.__less

        # copy array
        aux[lo:hi+1] = a[lo:hi+1].copy()

        # merge
        i = lo
        j = mid + 1
        for k in range(lo, hi + 1):
            if i > mid:
                a[k] = aux[j]
                j += 1
            elif j > hi:
                a[k] = aux[i]
                i += 1
            elif less(aux[j], aux[i]):
                a[k] = aux[j]
                j += 1
            else:
                a[k] = aux[i]
                i += 1

    def __less(v, w):
        return v < w
