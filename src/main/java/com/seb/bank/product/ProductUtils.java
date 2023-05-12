package com.seb.bank.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seb.bank.product.entity.Product;
import com.seb.bank.product.model.IProduct;
import com.seb.bank.product.model.ProductData;
import com.seb.bank.product.model.ProductType;
import com.seb.bank.product.model.accounts.Account;
import com.seb.bank.product.model.cards.Card;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.seb.bank.product.model.ProductType.ACCOUNT;
import static com.seb.bank.product.model.ProductType.CARD;
import static java.util.stream.Collectors.toList;

public class ProductUtils {

    public static IProduct toIProduct(Product it) {
        return ProductType.CARD.equals(it.getProduct())
                ? new Card(it.getName(), CARD)
                : new Account(it.getName(), ACCOUNT);
    }

    public static ProductData toProductData(Product product) {
        return new ProductData(product);
    }

    public static List<ProductData> getDefaultProducts() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("products.json");
            ProductData[] products = objectMapper.readValue(file, ProductData[].class);

            return Arrays
                    .stream(products)
                    .collect(toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
