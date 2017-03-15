# Slim Docker Images

Slides, resources and examples for [1st Docker Ljubljana meetup][docker-meetup] by [Oto Brglez][otobrglez], March 2017.

Repository comes with example Scala app and bunch of Dockerfiles where each of the tips is implemented and demonstrated.

> Why Scala? Example needed to be complex enough and big enough to matter. If you write apps in C/C++/Go or some other low level compiled language where result is single binary your images would abiously be much smaller.

## 10 general tips

1. Few layers.
2. Cleanup whenever possible
3. Lighter base images ([Alpine Linux][alpine], [BusyBox][busybox] `slim` or `onbuild`)
4. Less "general" images.
5. Split images (one for build, one for test, one for run?).
6. Split responsibility (SRP) and KISS.
7. `.dockerignore`.
8. `copy` & extract from host to `image`.
9. THINK & inspect what you install.
10. test & measure before you optimise.

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

- Inspect with (MicroBadger)[https://microbadger.com]

[otobrglez]: https://github.com/otobrglez
[docker-meetup]: https://www.meetup.com/Docker-Ljubljana/events/237617613/
[alpine]: https://hub.docker.com/_/alpine/
[akka-http]: http://doc.akka.io/docs/akka-http/current/scala.html
[java]: https://www.java.com/
[scala]: https://www.scala-lang.org/
[sbt]: http://www.scala-sbt.org/
[busybox]: https://hub.docker.com/_/busybox/
