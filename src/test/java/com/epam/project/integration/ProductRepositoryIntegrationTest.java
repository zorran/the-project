package com.epam.project.integration;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.epam.project.TheProjectApplication;
import com.epam.project.data.Product;
import com.epam.project.repositories.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TheProjectApplication.class)
@WebAppConfiguration
public class ProductRepositoryIntegrationTest {
    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    private ProductRepository repository;

    @Before
    public void setup() throws Exception {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

        CreateTableRequest tableRequest = dynamoDBMapper
            .generateCreateTableRequest(Product.class);
        tableRequest.setProvisionedThroughput(
            new ProvisionedThroughput(1L, 1L));
        ListTablesResult tables = amazonDynamoDB.listTables();
        if (!tables.getTableNames().contains("orders")) {
            amazonDynamoDB.createTable(tableRequest);
        }

        //...

        //dynamoDBMapper.batchDelete(
        //    (List<Product>)repository.findAll());
    }

    @Test
    public void test() {
        Product product = Product.builder()
            .name("test")
            .cost("10")
            .build();

        repository.save(product);

        List<Product> result = (List<Product>) repository.findAll();

        assertThat(result.size()).isGreaterThan(0);
        assertThat(result.get(0).getName()).isEqualTo("test");
        assertThat(result.get(0).getCost()).isEqualTo("10");
    }
}
