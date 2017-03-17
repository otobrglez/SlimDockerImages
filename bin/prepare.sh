#!/usr/bin/env bash
set -ex

SCALA_VERSION=2.12.1
SCALA_SBT_VERSION=0.13.13
SBT_VERSION=0.13.13

mkdir -p ./pkg

if [ ! -f "./pkg/scala-${SCALA_VERSION}.deb" ]; then
  wget http://downloads.lightbend.com/scala/${SCALA_VERSION}/scala-${SCALA_VERSION}.deb \
    -O ./pkg/scala-${SCALA_VERSION}.deb
fi

if [ ! -f "./pkg/sbt-${SCALA_SBT_VERSION}.deb" ]; then
  wget https://dl.bintray.com/sbt/debian/sbt-${SCALA_SBT_VERSION}.deb \
    -O ./pkg/sbt-${SCALA_SBT_VERSION}.deb
fi

if [ ! -f "./pkg/sbt-${SBT_VERSION}.tgz" ]; then
  wget http://dl.bintray.com/sbt/native-packages/sbt/$SBT_VERSION/sbt-$SBT_VERSION.tgz \
    -O "./pkg/sbt-${SBT_VERSION}.tgz"
fi
