val subscription: Disposable = dataStream.subscribe(
	onNext={ emitedItem ->
		println(emitedItem)
	}, onError={ error ->
		println(error)
	}, onComplete={
		println("completed")
	}
)

subscription.dispose()