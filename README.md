# Slim Docker Images

Slides, resources and examples for [1st Docker Ljubljana meetup][docker-meetup] by [Oto Brglez][otobrglez]

## Example app

Simple Scala [Akka http][akka-http] JSON web service that replies some text and current date/time.

```bash
ECHOWS=localhost:7777/\?name=Oto
curl $ECHOWS
```

"pure" jar size
```bash
ls -lh target/**/echo.jar
# ~ 23M
```

## General tips

1. Few layers.
2. Cleanup whenever possible (after each layer).
3. Lighter base images ([Alpine Linux][alpine], `:slim` or `onbuild`) - do you need Ubuntu?
4. Less "general" images.
5. Split images (one for build, one for test, one for run).
6. Split responsibility (SRP) and KISS.
7. `.dockerignore`.
8. `copy` & extract from host to `image`.
9. THINK & inspect what you install.
10. test & measure before you optimise.


## Other

- Inspect with (MicroBadger)[https://microbadger.com]

[otobrglez]: https://github.com/otobrglez
[docker-meetup]: https://www.meetup.com/Docker-Ljubljana/events/237617613/
[alpine]: https://hub.docker.com/_/alpine/