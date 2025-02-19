#!/bin/sh

echo "Waiting for DynamoDB Local to start..."
sleep 5  # 起動を待機

aws dynamodb create-table \
    --table-name User \
    --attribute-definitions AttributeName=id,AttributeType=S \
    --key-schema AttributeName=id,KeyType=HASH \
    --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 \
    --endpoint-url http://localhost:4566 \
    --region us-east-1

echo "DynamoDB tables created successfully !"
