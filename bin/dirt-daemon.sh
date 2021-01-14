#!/bin/sh
cd $(dirname "$0")/../

java -cp "dirtd.jar:lib/*" -Dconfig="cfg/db.ini" -Dlog4j.configurationFile="cfg/log4j2.xml" dev.pagefault.eve.dirtd.DirtTaskDaemon $@
