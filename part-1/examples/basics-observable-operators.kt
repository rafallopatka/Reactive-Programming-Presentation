val dataStream: Observable<Decimal> = ... // observable source

val exampleObservable = dataStream
	.filter { it -> it < 100 } // c# where
	.distinct()
	.skip(1000)
	.take(1000)
	.map { it -> it * 2 } // c# Select
	.buffer(100)
	.flatMap { calculate1Observable(it) } // c# SelectNany
	.concatMap { calculate2Observable(it) } // c# Concat
	.switchMap { calculate3Observable(it) } // c# Switch

val subscription: Disposable = exampleObservable.subscribe(
	onNext={ emitedItem ->
		println(emitedItem)
	}, onError={ error ->
		println(error)
	}, onComplete={
		println("completed")
	}
)

subscription.dispose()
 