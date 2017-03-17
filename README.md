[![Slides](./slides.png)][slides]

[Slides][slides], resources and examples for [1st Docker Ljubljana meetup][docker-meetup] by [Oto Brglez][otobrglez], March 2017.

Repository comes with example Scala app and bunch of Dockerfiles where each of the tips is implemented and demonstrated.

> Why Scala? Example needed to be complex enough and big enough to matter. If you write apps in C/C++/Go or some other low level compiled language where result is single binary your images would obviously be much smaller.

## 10 general tips

1. [SRP][srp] and [KISS][kiss] - [00](Dockerfile.00)
2. Few layers - [01](Dockerfile.01)
3. Cleanup - [02](Dockerfile.02)
4. copy & extract from host - [03](Dockerfile.03)
5. Less "general" images and lighter base images. [04](Dockerfile.04) + [05](Dockerfile.05)
6. Split [06](Dockerfile.06)
7. [.dockerignore](.dockerignore)
8. THINK & inspect what you install
9. test & measure before you optimise
10. Do not build SW in the container


## Example app

Simple [Akka HTTP][akka-http] JSON web service that replies with some text and current date/time. Dependencies: [Scala], [SBT], [Java 8][java].

```bash
curl http://localhost:7777/\?name=Oto
```

Fat-jar size is around 23M.
```bash
ls -lh target/**/echo.jar
# ~ 23M
```

## Other

- Inspect with [MicroBadger](https://microbadger.com)
- Try [Docker Slim](https://github.com/docker-slim/docker-slim)

## Credits

- [Oto Brglez](https://github.com/otobrglez)
- [Jožko Škrablin](https://github.com/jozko)

[otobrglez]: https://github.com/otobrglez
[docker-meetup]: https://www.meetup.com/Docker-Ljubljana/events/237617613/
[alpine]: https://hub.docker.com/_/alpine/
[akka-http]: http://doc.akka.io/docs/akka-http/current/scala.html
[java]: https://www.java.com/
[scala]: https://www.scala-lang.org/
[sbt]: http://www.scala-sbt.org/
[busybox]: https://hub.docker.com/_/busybox/
[srp]: https://en.wikipedia.org/wiki/Single_responsibility_principle
[kiss]: https://en.wikipedia.org/wiki/KISS_principle
[slides]: https://docs.google.com/presentation/d/1K0DHW31W5cj1d9hxzAn0sDSKntGpDVdaUzUy1HKZ1XU/edit?usp=sharing

