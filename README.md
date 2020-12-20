# kotlin-js-headless-chrome

URL capture and post to Slack using Headless Browser in Kotlin/JS and running with Cloud Functions for Firebase.

![image](https://raw.githubusercontent.com/sakebook/kotlin-js-headless-chrome/main/art/capture.png)

## Environment
- Kotlin v1.4.21
- Gradle v6.3
- dukat v0.5.8-rc.3
- Node v12

## Build

```sh
$ ./gradlew clean compileKotlinJs
```

## Debug

Running local server.

You need replace [`SlackConfig`](https://github.com/sakebook/kotlin-js-headless-chrome/blob/main/src/main/kotlin/Main.kt#L12).

```sh
$ ./gradlew clean cKJ packaging && cd functions && npm install && npx @google-cloud/functions-framework --target=capture ; cd -
```

## Deploy

You need setup gcloud.

```sh
$ ./gradlew clean 
$ rm -rf functions
$ gcloud builds submit . --config cloudbuild.yaml
```

---

## [LICENSE](https://github.com/sakebook/kotlin-js-headless-chrome/blob/main/LICENSE)
Copyright (c) 2020 sakebook Licensed under the [Apache License](https://github.com/sakebook/kotlin-js-headless-chrome/blob/main/LICENSE).
