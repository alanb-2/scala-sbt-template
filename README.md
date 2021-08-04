# scala-sbt-template

Template repository to serve as a minimal base for Scala projects.  See `build.sbt` and `project` for library versions.

All commands are run from the project root.  Note that the examples are given for execution from the CLI.  Commands will 
execute more quickly if the `sbt` shell is used instead.

## Prerequisites

* Java 11
* Sbt 1.4.7
* Python 3

### pre-commit

1.  OPTIONAL: create a virtual environment to install pre-commit in e.g.
    ```shell
    python -m venv .venv 
    ```
    Note: it's recommended to create a new environment for each project that uses `pre-commit` so that the configurations
    do not need to be initialised when switching projects.
    
2.  OPTIONAL: activate the virtual environment e.g.
    ```shell
    . .venv/bin/activate
    ```

3.  Install `pre-commit`
    ```shell
    pip install pre-commit
    ```
    
4.  Configure `pre-commit`
    ```shell
    pre-commit install
    ```

For advanced configuration options see https://pre-commit.com/

## Commands

### Format

```shell
sbt scalafmt
```

```shell
sbt scalafmtSbt
```
The project uses the `scalafmt` plugin and rules defined in `.scala.fmt.conf`.  More advanced execution options are 
available at https://scalameta.org/scalafmt/docs/installation.html#task-keys

### Compile

```shell
sbt clean compile
```

### Test

```shell
sbt clean test
```

### Coverage

```shell
sbt jacoco
```

### Package

#### JAR

```shell
sbt clean package
```

#### JAR + source

```shell
sbt clean dist
```

#### Fat JAR

```shell
sbt clean assembly
```

For advanced configuration options check https://github.com/sbt/sbt-assembly.

#### Docker

```shell
sbt clean Docker/publishLocal
```

### Execute

#### Code

```shell
sbt clean compile "run arg1 arg2 arg3"
```

#### Artifact

1. Build the fat-JAR

2. Make the JAR executable:
    ```shell
    chmod +x core/target/scala-sbt-template-core.jar
    ```
 
3. Run the JAR:
    ```shell
    java -jar core/target/scala-sbt-template-core.jar "arg1" "arg2" "arg3"
    ```
    This should result in the following output:
    ```shell
    Hello, world with [arg1, arg2, arg3]
    add(1, 2) = 3
    ```
