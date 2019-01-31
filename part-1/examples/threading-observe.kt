// Main thread: 1
Observable.range(1, 10) // Thread: IO 16
	.subscribeOn(Schedulers.io())
	.observeOn(Schedulers.computation())
	.map { it * 100 } // Thread COMPUTATION: 18
	.observeOn(Schedulers.single())
	.map { it / 10 } // Thread SINGLE: 20
	.subscribe { } // Thread SINGLE: 20
	 