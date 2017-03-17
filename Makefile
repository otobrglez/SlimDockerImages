.PHONY: all run-host

all:
	"ok"

run-host:
	cd ./example-apps/echo && sbt run

00:
	docker build -t otobrglez/sdi:00 -f Dockerfile.00 .

01:
	docker build -t otobrglez/sdi:01 -f Dockerfile.01 .

02:
	docker build -t otobrglez/sdi:02 -f Dockerfile.02 .

03:
	docker build -t otobrglez/sdi:03 -f Dockerfile.03 .

04:
	./bin/prepare.sh
	docker build -t otobrglez/sdi:04 -f Dockerfile.04 .

05:
	./bin/prepare.sh
	docker build -t otobrglez/sdi:05 -f Dockerfile.05 .

06:
	./bin/prepare.sh
	docker build -t otobrglez/sdi:06 -f Dockerfile.06 .
