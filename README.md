# Declarative IDE APIs Spike Examples

This repository contains examples consuming spike declarative IDE APIs.

It relies on a modified Tooling API JAR that can be found in the [lib/](./lib) directory.

## Build tree without the daemon

Run the query on this very build:

```shell
./gradlew :build-tree:run
```

Run the query on another build by passing the `projectDir` system property.
For example on `nowinandroid` located alongside this repository's clone:

```shell
./gradlew :build-tree:run -DprojectDir=../../nowinandroid
```

See client implementation in [build-tree/src/main/java/Main.java](./build-tree/src/main/java/Main.java).
