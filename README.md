# credentials-service

## Getting Started
### Protobuf

- Add Google dependency:
```xml
<dependency>
    <groupId>com.google.protobuf</groupId>
    <artifactId>protobuf-java</artifactId>
    <version>3.5.1</version>
</dependency>
```
- Install protobuf:

Linux:
```bash
PROTOC_ZIP=protoc-3.3.0-linux-x86_64.zip
curl -OL https://github.com/google/protobuf/releases/download/v3.3.0/$PROTOC_ZIP
sudo unzip -o $PROTOC_ZIP -d /usr/local bin/protoc
rm -f $PROTOC_ZIP
```

MacOS:
```bash
brew install protobuf
```

- Generate Java source code file:
```bash
protoc --proto_path=. --java_out=src/main/java credentials.proto 
```
