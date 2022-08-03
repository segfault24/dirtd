#!/bin/sh

/usr/bin/java -Xms20m -Xmx200m \
    -cp "dirt-scraper.jar:lib/*" \
    -Dconfig="cfg/db.ini" \
    -Dlog4j.configurationFile="cfg/log4j2.xml" \
    dev.pagefault.eve.dirtd.FirstRun
