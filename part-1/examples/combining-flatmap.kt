val userDownloads = Observable
	.fromArray(Pair("File1", 6L), Pair("File2", 4L), Pair("File3", 2L))

fun downloadFile(file: String, delay: Long) = Observable.just(file)
	.delay(delay, TimeUnit.SECONDS)
	.map { "$it OK" }

userDownloads.flatMap { (file, delay) -> downloadFile(file, delay) }
	.blockingSubscribe { }

/* ######################################## OUTPUT ######################################### */
--(File1,6S)--(File2,4S)--(File3,2S)--|--------------------------------------------------------
===============================================================================================
                                           FlatMap()
--\------------------------(File1 OK)--|-------------------------------------------------------
--\----------------(File2 OK)--|---------------------------------------------------------------
--\--------(File3 OK)--|-----------------------------------------------------------------------
===============================================================================================
-----------(File3 OK)--(File2 OK)--(File1 OK)--|-----------------------------------------------
 