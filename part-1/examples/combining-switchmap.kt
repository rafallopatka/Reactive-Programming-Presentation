userDownloads.switchMap { (file, delay) -> downloadFile(file, delay) }
	.blockingSubscribe { }

/* ######################################## OUTPUT ######################################### */
--(File1,6S)--(File2,4S)--(File3,2S)--|--------------------------------------------------------
===============================================================================================
                                           SwitchMap()
--\-----------/|-------------------------------------------------------------------------------
--------------\-----------/|-------------------------------------------------------------------
--------------------------\--------(File3 OK)--|-----------------------------------------------
===============================================================================================
-----------------------------------(File3 OK)--|-----------------------------------------------
 