// Main thread: 1
Observable.range(1, 10) // Thread: 16
	.subscribeOn(Schedulers.io())
	.map { it * 100 } // Thread: 16
	.subscribe { } // Thread: 16