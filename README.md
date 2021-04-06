# scala-sbt-template

Template repository to serve as a minimal base for Scala projects.  See `build.sbt` and `project` for library versions.

All commands are run from the project root.  Note that the examples are given for execution from the CLI.  Commands will 
execute more quickly if the `sbt` shell is used instead.

## Formatter

```shell
sbt scalafmt
```

```shell
sbt scalafmtSbt
```
The project uses the `scalafmt` plugin and rules defined in `.scala.fmt.conf`.  More advanced execution options are 
available at https://scalameta.org/scalafmt/docs/installation.html#task-keys

## Compile

```shell
sbt clean compile
```

## Test

```shell
sbt clean test
```

## Coverage

```shell
sbt jacoco
```

## Package

### JAR only

```shell
sbt clean package
```

### JAR + source

```shell
sbt clean dist
```

### Fat JAR

```shell
sbt clean assembly
```

For advanced configuration options check https://github.com/sbt/sbt-assembly.

### Docker

```shell
sbt clean Docker/publishLocal
```

## Execute

```shell
sbt clean compile "run arg1 arg2 arg3"
```
