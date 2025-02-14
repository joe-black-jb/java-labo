# Spring Boot + DynamoDB

## 参考資料

- [コンピュータ上で DynamoDB をローカルでデプロイする（AWS ドキュメント）](https://docs.aws.amazon.com/ja_jp/amazondynamodb/latest/developerguide/DynamoDBLocal.DownloadingAndRunning.html)
- [Docker で Spring Boot（Spring Boot ドキュメント）](https://spring.pleiades.io/guides/gs/spring-boot-docker)

## コマンド

```sh
# Docker 起動
docker-compose up (--build)

# mvn 起動
mvn spring-boot:run

# Docker コンテナを一時的に実行し、app ディレクトリの中を確認する
docker run --rm <image> ls -R /app

# DynamoDB 疎通確認 (https://docs.aws.amazon.com/ja_jp/amazondynamodb/latest/developerguide/DynamoDBLocal.DownloadingAndRunning.html)
## DB のみ Docker で立ち上げている場合
aws dynamodb describe-limits --endpoint-url http://localhost:8000 --region us-west-2
## アプリも Docker で立ち上げていて、アプリコンテナから通信する場合
dynamodb describe-limits --endpoint-url http://dynamodb-local:8000 --region us-west-2
```

## 依存関係

### DynamoDB 関連

- spring-cloud-starter-aws
- spring-data-dynamodb ([github](https://github.com/michaellavelle/spring-data-dynamodb))
- aws-dynamodb-encryption-java
