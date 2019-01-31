// Main thread: 10
Observable.range(1, 10) // Thread: 10
	.map { it * 100 } // Thread: 10
	.subscribe { }  // Thread: 10