val observableNumbers = Observable.range(0, 5)
val observableTime = Observable.interval(100, TimeUnit.MILLISECONDS)

val numbersInPeriodObservable =
	Observable.zip<Int, Long, Long>(observableNumbers, observableTime, BiFunction { 
		tick, number -> return@BiFunction number * tick
	})

numbersInPeriodObservable
	.blockingSubscribe({
		println("onNext: $it")
	}, {}, {
		println("onComplete")
	})

/* ######################################## OUTPUT ######################################### */
--(0)--(1)--(2)--(3)--(4)--(5)--|--------------------------------------------------------------
--(1)--------(2)--------(3)--------(4)--------(5)--------(6)--------(7)--------(8)-----(...)-->
===============================================================================================
                                       Zip(number * tick)
===============================================================================================
--(0)--------(2)--------(6)--------(12)-------(20)-------(30)--|-------------------------------