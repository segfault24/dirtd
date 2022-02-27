#!/bin/bash

mvn exec:java \
	-Dexec.mainClass=dev.pagefault.eve.dirtd.DirtDaemon \
	-Dconfig=cfg/db.ini \
	-Dlog4j.configurationFile="cfg/log4j2.xml"
