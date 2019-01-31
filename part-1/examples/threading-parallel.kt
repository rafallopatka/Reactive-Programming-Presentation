val jobs: Observable<Job> = JobSource.create()

jobs.toFlowable(BackpressureStrategy.BUFFER)
	.parallel(10)
	.runOn(Schedulers.io())
	.map { it.execute() }
	.sequential()
	.distinctUntilChanged()
	.toObservable()
	.subscribe {
		
	}		