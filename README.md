# scala-sbt-start-kit

When starting scala project in sbt, this start-kit can be used. 

sbt를 이용하여 scala 프로젝트를 시작할 때, 사용하기 위해서 만든 프로젝트

## How to use

### Clone start-kit into own folder

```bash
$ git clone https://github.com/jungbin-kim/scala-sbt-start-kit.git {folder name}
```

### Custom project

- Remove git remote origin

```bash
# Move project path
$ cd {path/project/folder}

# View remotes
$ git remote -v
origin  https://github.com/jungbin-kim/scala-sbt-start-kit.git (fetch)
origin  https://github.com/jungbin-kim/scala-sbt-start-kit.git (push)

# Remove remote origin
$ git remote rm origin
```
- Add other git remote origin

```bash
$ git remote add origin {git repository url}
```

- Edit name in [build.sbt](./build.sbt)

- Check project running

```bash
$ sbt run
```

- Structure of project following [sbt project convention](http://www.scala-sbt.org/1.0/docs/Hello.html)
    + Sources in the base directory
    + Sources in src/main/scala or src/main/java
    + Tests in src/test/scala or src/test/java
    + Data files in src/main/resources or src/test/resources
    + jars in lib
  
## Error Handling
- `git clone` 후 IntelliJ에서 열면 sbt import가 안되고 Java `Null Point Exception` 나는 경우
    + &#8984; + `;` (Project Settings) -> `Modules` -> `Paths` -> `Compile output path` 확인
    + project root에 target 폴더가 없어서 해당 에러가 발생하였음.
