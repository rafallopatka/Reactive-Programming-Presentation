val arrayObservable: Observable<Int> = Observable.fromArray(1,2,3)

val intObservable: Observable<Int> = Observable.fromCallable { 2 * 2 * 2 }

val singleItemObservable: Observable<Boolean> = Observable.just(true)

val errorObservable: Observable<Int> = Observable.error<Int>(IllegalStateException())

val interval: Observable<Int> = Observable.interval(10, TimeUnit.SECONDS)