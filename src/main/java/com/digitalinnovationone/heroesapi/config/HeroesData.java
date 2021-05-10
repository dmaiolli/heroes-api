package com.digitalinnovationone.heroesapi.config;

import static com.digitalinnovationone.heroesapi.constants.HeroesConstant.ENDPOINT_DYNAMODB;
import static com.digitalinnovationone.heroesapi.constants.HeroesConstant.REGION_DYNAMODB;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

public class HeroesData {
    public static void main(String[] args) {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMODB, REGION_DYNAMODB))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("TB_HEROES");
        Item hero = new Item()
                .withPrimaryKey("id", 1)
                .withString("name", "Mulher maravilha")
                .withString("universe", "dc comics")
                .withNumber("filmes", 3);

        PutItemOutcome outcome = table.putItem(hero);
    }

}
