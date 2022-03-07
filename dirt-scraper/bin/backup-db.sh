#!/bin/bash

mysqldump -u root eve \
  --ignore-table=eve.region \
  --ignore-table=eve.constellation \
  --ignore-table=eve.solarsystem \
  --ignore-table=eve.station \
  --ignore-table=eve.invtype \
  --ignore-table=eve.marketgroup \
  --ignore-table=eve.industryactivityproducts \
  --ignore-table=eve.invtypematerials \
  --ignore-table=eve.apireq \
  --ignore-table=eve.insuranceprice \
  --ignore-table=eve.latestset \
  --ignore-table=eve.orderset \
  --ignore-table=eve.marketorder \
  --ignore-table=eve.dentity \
  --ignore-table=eve.dlocation \
  --ignore-table=eve.vamarrbestbuy \
  --ignore-table=eve.vamarrbestsell \
  --ignore-table=eve.vjitabestbuy \
  --ignore-table=eve.vjitabestsell \
  | gzip -9 -c > /root/eve-backup-`date +%Y-%m-%d_%H-%M-%S`.sql.gz
