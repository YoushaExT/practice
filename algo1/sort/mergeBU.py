
class MergeBU:

    aux = []

    def sort(a):
        # method alias
        merge = MergeBU.__merge

        n = len(a)
        sz = 1
        while (sz < n):
            lo = 0
            while (lo < n - sz):
                merge(a, lo, lo + sz - 1, min(lo + sz + sz - 1, n - 1))
                lo += sz + sz
            sz = sz + sz

    def __merge(a, lo, mid, hi):
        # method alias
        less = MergeBU.__less
        aux = MergeBU.aux

        # copy array
        aux[lo:hi + 1] = a[lo:hi + 1].copy()

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
