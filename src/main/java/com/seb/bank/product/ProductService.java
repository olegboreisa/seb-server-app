package com.seb.bank.product;

import com.seb.bank.product.entity.Product;
import com.seb.bank.product.model.IProduct;
import com.seb.bank.product.model.IncomeForm;
import com.seb.bank.product.model.ProductData;
import com.seb.bank.product.model.ProductForm;
import com.seb.bank.product.model.accounts.CurrentAccount;
import com.seb.bank.product.model.accounts.CurrentAccountPlus;
import com.seb.bank.product.model.accounts.JuniorAccount;
import com.seb.bank.product.model.accounts.SeniorAccount;
import com.seb.bank.product.model.accounts.StudentAccount;
import com.seb.bank.product.model.cards.CreditCard;
import com.seb.bank.product.model.cards.DebitCard;
import com.seb.bank.product.model.cards.GoldenCard;
import com.seb.bank.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.seb.bank.product.ProductUtils.*;
import static com.seb.bank.product.model.ProductType.ACCOUNT;
import static com.seb.bank.product.model.ProductType.CARD;
import static java.util.stream.Collectors.toList;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<IProduct> getApplicableProducts(IncomeForm form) {
        List<Product> createdProducts = productRepository.findAllByStudentIs(form.isStudent());
        List<IProduct> products = createdProducts
                .stream()
                .filter(it -> form.getAge() >= it.getValidFrom())
                .filter(it -> form.getIncome().getValue() >= it.getIncome().getValue())
                .map(ProductUtils::toIProduct)
                .collect(toList());

        if (form.getAge() > 17) {
            switch(form.getIncome()) {
                case HIGH:
                    products.add(new GoldenCard("Golden", CARD));
                    products.add(new CurrentAccountPlus("Current Plus", ACCOUNT));
                case MEDIUM:
                    products.add(new CreditCard("Credit", CARD));
                case LOW:
                    products.add(new DebitCard( "Debit", CARD));
                    products.add(new CurrentAccount("Current", ACCOUNT));
                    break;
            }

            if (form.isStudent()) {
                products.add(new StudentAccount("Student", ACCOUNT));
            }

            if (form.getAge() >= 65) {
                products.add(new SeniorAccount( "Senior", ACCOUNT));
            }

        } else {
            products.add(new JuniorAccount("Junior", ACCOUNT));
        }

        return products;
    }

    public void upsert(ProductForm form) {
        if (form.getId() != null) {
            update(form);
        } else {
            productRepository.save(new Product(form));
        }
    }

    public List<ProductData> getAll() {
        List<ProductData> allProducts = new ArrayList<>();
        List<ProductData> defaultProducts = getDefaultProducts();
        List<ProductData> createdProducts = productRepository.findAll()
                .stream()
                .map(ProductUtils::toProductData)
                .collect(toList());

        allProducts.addAll(defaultProducts);
        allProducts.addAll(createdProducts);
        return allProducts;
    }

    public void delete(long id) {
        productRepository.deleteById(id);
    }

    public ProductForm getOne(long id) {
        Product product = productRepository.getOne(id);
        return new ProductForm(product);
    }

    private void update(ProductForm form) {
        Product product = productRepository.getOne(form.getId());
        product.setName(form.getName());
        product.setProduct(form.getProduct());
        product.setValidFrom(form.getValidFrom());
        product.setStudent(form.isStudent());
        product.setIncome(form.getIncome());
        productRepository.save(product);
    }
}