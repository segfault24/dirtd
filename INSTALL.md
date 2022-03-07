# Installation

These instructions are based on Ubuntu 20.04, MySQL 8.0.28 and are provided for example only.

## Database
Configure `/etc/mysql/mysql.conf.d/mysqld.conf`
```properties
[mysqld]
user = mysql
bind-address = 127.0.0.1,10.0.0.4
mysqlx-bind-address = 127.0.0.1
key_buffer_size = 16M
myisam-recover-options = BACKUP
log_error = /var/log/mysql/error.log
max_binlog_size = 100M
innodb_buffer_pool_size = 512M
skip-log-bin
```
Initialize schema
```shell
mysql -u root < /opt/dirtd/cfg/schema.sql
cp /opt/dirtd/cfg/dirt.sql.template /opt/dirtd/cfg/dirt.sql
vi /opt/dirtd/cfg/dirt.sql
mysql -u root < /opt/dirtd/cfg/dirt.sql
```

Allow access from VPC
```shell
ufw allow from 10.0.0.0/8 proto tcp to any port 3306
```
```mysql-sql
GRANT ALL ON eve.* TO 'dirt'@'10.0.0.0/255.0.0.0' IDENTIFIED BY 'passwordhere';
```

## ESI Scraper
```shell
apt install -y openjdk-11-jre-headless
useradd dirt
tar xf dirt-scraper-1.0.0.tar.gz -C /opt
mv /opt/dirt-scraper-1.0.0 /opt/dirtd
mkdir /opt/dirtd/logs
chown -R dirt:dirt /opt/dirtd/
ln -s /opt/dirtd/dirt-scraper-*.jar /opt/dirtd/dirt-scraper.jar
cp -f /opt/dirtd/bin/dirtd.service /etc/systemd/system/
systemctl daemon-reload
systemctl enable dirtd
cp /opt/dirtd/cfg/db.ini.template /opt/dirtd/cfg/db.ini
vi /opt/dirtd/cfg/db.ini
systemctl start dirtd
```

## WebUI
```shell

```
