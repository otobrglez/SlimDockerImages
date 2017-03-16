.PHONY: all run-host

all:
	"ok"

run-host:
	cd ./example-apps/echo && sbt run

00:
	docker build -t otobrglez/sdi:00 -f Dockerfile.00 .
