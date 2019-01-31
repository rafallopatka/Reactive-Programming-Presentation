// Main thread: 1
Observable.range(1, 10) // Thread: 16
	.map { it * 100 } // Thread: 16
	.subscribeOn(Schedulers.io())
	.observeOn(Schedulers.computation())
	.blockingSubscribe { } // Thread: 1