val userDownloads = Observable
	.fromArray(Pair("File1", 6L), Pair("File2", 4L), Pair("File3", 2L))

fun downloadFile(file: String, delay: Long): Observable<String> {
	return  Observable.just(file)
		.delay(delay, TimeUnit.SECONDS)
		.map { "$it OK" }
}

/* ######################################## OUTPUT ######################################### */
--(File1,6S)--(File2,4S)--(File3,2S)--|--------------------------------------------------------
 