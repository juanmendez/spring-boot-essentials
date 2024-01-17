# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.spring.boot.web.room-web-app' is invalid and this project uses 'com.spring.boot.web.roomwebapp' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.0-SNAPSHOT/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.0-SNAPSHOT/gradle-plugin/reference/html/#build-image)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

## Producer and Consumer - setup
- start up [docker application](https://www.docker.com/products/docker-desktop/)
- open terminal in current project
    - cd bin
    - enter `./start_rabbit.sh`
- Changes in application
    - added new dependency in `build.gradle.kts`
    - added new content in this package `.async`
    - added new class `.config.syncConfig`
    - run the application
- Go to `http://localhost:15672/`, you should see RabbitMQ login screen
    - user/password: guest/guest
    - Ensure 'Queues' tab is selected, and you should see `room-cleaner` as the only queue. This is the url `http://localhost:15672/#/queues/%2F/room-cleaner`
    - Type the following under `Publish message`
        - Properties: `content_type`, `text/plain`
        - Payload: ```{"id":25,"model":"ROOM"}```
        - click on `Publish Message`
        - See results below


<img width="1251" alt="image" src="https://github.com/juanmendez/spring-boot-essentials/assets/3371622/7b35f8b6-8edd-4c2e-888c-8a4e5d43ebc0">


<img width="1484" alt="image" src="https://github.com/juanmendez/spring-boot-essentials/assets/3371622/572c54fe-b656-4baf-a399-bc47c2a5dce4">


<img width="1260" alt="image" src="https://github.com/juanmendez/spring-boot-essentials/assets/3371622/d55f2e2f-714f-459e-8900-6e59e011d6a9">
