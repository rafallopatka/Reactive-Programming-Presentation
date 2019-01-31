val probesObservable = ExampleSensor.probesObservable
	.timeout(10L, TimeUnit.SECONDS)

val deviations = probesObservable
	.distinctUntilChanged()
	.filter { it !in ExampleSensor.MinNorm .. ExampleSensor.MaxNorm }
	.timestamp()
	.buffer(5, TimeUnit.SECONDS)
	.filter { it.isNotEmpty() }
	.subscribe({ data ->
		println("Persistence - ${data.count()}")
		persist(data = data)
	}, { error ->
		println("Persistence error - $error")
	})

val sample = probesObservable
	.sample(1, TimeUnit.SECONDS)
	.subscribe {
		println("sample - $it")
	}

val median = probesObservable
	.buffer(1000,500)
	.map { it.median() }
	.distinctUntilChanged()
	.subscribe {
		println("Median - $it")
	}

val realTimeAvg = probesObservable
	.scan(AvgValue(0, 0)) { accumulator, current ->
		val numberOfProbes = accumulator.numberOfProbes + 1
		val sumOfAllProbes = accumulator.sumOfAllProbes + current
		AvgValue(numberOfProbes = numberOfProbes, sumOfAllProbes = sumOfAllProbes)
	}
	.filter { it.numberOfProbes > 0 }
	.map { it.sumOfAllProbes / it.numberOfProbes }
	.distinctUntilChanged()
	.subscribe {
		println("Avg - $it")
	}

ExampleSensor.connect()