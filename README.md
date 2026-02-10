# Getting Started

### Installation

To setup maven project, run the following command in the terminal:

```bash
nano ~/.m2/settings-public.xml
```

Then add the following content to the file:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 
          http://maven.apache.org/xsd/settings-1.0.0.xsd">

  <mirrors>
    <mirror>
      <id>maven-central</id>
      <name>Maven Central Repository</name>
      <url>https://repo.maven.apache.org/maven2</url>
      <mirrorOf>central</mirrorOf>
    </mirror>
  </mirrors>

  <profiles>
    <profile>
      <id>public</id>
      <repositories>
        <repository>
          <id>central</id>
          <url>https://repo.maven.apache.org/maven2</url>
          <releases>
            <enabled>true</enabled>
          </releases>
          <snapshots>
            <enabled>false</enabled>
          </snapshots>
        </repository>
        <repository>
          <id>spring-milestones</id>
          <url>https://repo.spring.io/milestone</url>
          <releases>
            <enabled>true</enabled>
          </releases>
          <snapshots>
            <enabled>false</enabled>
          </snapshots>
        </repository>
      </repositories>
    </profile>
  </profiles>

  <activeProfiles>
    <activeProfile>public</activeProfile>
  </activeProfiles>

</settings>
```

### Build the application

```bash
mvn clean install -s ~/.m2/settings-public.xml
```

### Run the application

```bash
mvn spring-boot:run -s ~/.m2/settings-public.xml
```

### Verify the application health

```bash
curl http://localhost:8082/actuator/health
```
