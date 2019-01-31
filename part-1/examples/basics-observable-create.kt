object ITeratorObservable {
    fun <TRangeType : Comparable<TRangeType>> create(range: Iterable<TRangeType>)
        : Observable<TRangeType> {
        return Observable.create<TRangeType> { emitter ->
            try {
                for (i in range) {
                    if (emitter.isDisposed) {
                        break
                    }

                    emitter.onNext(i)
                }
                emitter.onComplete()
            } catch (e: Exception) {
                emitter.onError(e)
            }
        }
    }
}

val rangeObservable: Observable<Int> = IteratorObservable.create(1..1000)

/* ######################################## OUTPUT ######################################### */
--(1)--(2)--(3)--(4)--(5)--(6)--(7)--(8)--(9)--(10)--(11)--(12)--(13)----(...)---------(1000)-|
 