#!/bin/sh
cd $(dirname "$0")/../

java -cp "dirtd.jar:lib/*" -Dconfig="cfg/db.ini" dev.pagefault.eve.dirtd.PriceCompare $@
