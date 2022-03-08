#!/bin/bash

mysqldump -u root eve \
  | gzip -9 -c > /root/eve-backup-`date +%Y-%m-%d_%H-%M-%S`.sql.gz
