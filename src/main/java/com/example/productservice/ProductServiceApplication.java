package com.example.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {
//
//    private final com.example.productservice.repository.categoryRepository categoryRepository;
//    private final PriceRepository priceRepository;
//    private final com.example.productservice.repository.productRepository productRepository;
//
//    public ProductServiceApplication(categoryRepository categoryRepository,
//                                     PriceRepository priceRepository,
//                                     productRepository productRepository) {
//        this.categoryRepository = categoryRepository;
//        this.priceRepository = priceRepository;
//        this.productRepository = productRepository;
//    }
////*********************************************************************************************************************
//    private final com.example.productservice.repository.categoryRepository categoryRepository;
//    private final com.example.productservice.repository.productRepository productRepository;
//    private final PriceRepository priceRepository;
//
//    public ProductServiceApplication(categoryRepository categoryRepository,
//                                     productRepository productRepository,
//                                     PriceRepository priceRepository) {
//        this.categoryRepository = categoryRepository;
//        this.productRepository = productRepository;
//        this.priceRepository = priceRepository;
//    }
//    private MentorRepository mentorRepository;
//
//    ProductServiceApplication(@Qualifier("tpc_mentorRepository") MentorRepository mentorRepository){
//    this.mentorRepository=mentorRepository;
//    }
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        Mentor mentor = new Mentor();
//        mentor.setName("Priya");
//        mentor.setEmail("priyas5693@hgamil.com");
//        mentor.setAvgRating(9.5);
//
//        mentorRepository.save(mentor);
//        Category category = new Category();
//        category.setName("Apple Devices");
//        Category savedcategory=categoryRepository.save(category);

//*******************************************************************************************************************
    // **** This is optional category ****
//        Optional<Category> optionalCategory=categoryRepository.findById(UUID.fromString("abdb0f33-ef2d-4776-ad7d-39cd021746bb"));
//         // Get optional category to Category
//        if(optionalCategory.isEmpty()){
//           throw new Exception("Category not found");
//        }
//        Category category= optionalCategory.get();
//        //get all the products with category= Apple Devices
//        List<Product> product= category.getProducts();
//        for(Product products:product){
//            System.out.println(products.getTitle());
//        }
//*******************************************************************************************************************
//        Product product=new Product();
//        product.setTitle("Iphone 15 max pro");
//        product.setDescription("Latest Iphone model ");
//        product.setCategory(category.get());
//        Product savedproduct= productRepository.save(product);

//*********************************************************************************************************************
//        Price price = new Price();
//        price.setCurrency("INR");
//        price.setValue(50000);
//        Price savedprice = priceRepository.save(price);
//
//        Category category = new Category();
//        category.setName("Apple Devices");
//        Category savedcategory = categoryRepository.save(category);
//
//        Product product = new Product();
//        product.setTitle("Iphone 15 pro max");
//        product.setDescription("Latest Iphone 2023");
//        product.setCategory(savedcategory);
//        product.setPrice(savedprice);
//        Product savedproduct = productRepository.save(product);
//        productRepository.deleteById(UUID.fromString("688a20ff-76ee-4db8-92ee-397646763de8"));
//
//        Category category = new Category();
//        category.setName("Apple Devices");
//        Category savedcategory=categoryRepository.save(category);
//
//        Price price = new Price();
//        price.setValue(1000000);
//        price.setCurrency("INR");
//        //Price savedprice = priceRepository.save(price);
//
//        Product product = new Product();
//        product.setTitle("Apple Iphones");
//        product.setImage("IMG");
//        product.setDescription("iphone 15 max pro");
//        product.setCategory(category);
//        product.setPrice(price);
//        Product savedproduct= productRepository.save(product);
//
//        Price price1 = new Price();
//        price1.setValue(1000000);
//        price1.setCurrency("INR");
//        //Price savedprice1 = priceRepository.save(price1);
//
//        Product product1 = new Product();
//        product1.setTitle("Apple Iphones");
//        product1.setImage("IMG");
//        product1.setDescription("iphone 15 max pro");
//        product1.setCategory(category);
//        product1.setPrice(price1);
//        Product savedproduct1= productRepository.save(product1);
//
//        Price price2 = new Price();
//        price2.setValue(1000000);
//        price2.setCurrency("INR");
//        //Price savedprice2 = priceRepository.save(price2);
//
//        Product product2 = new Product();
//        product2.setTitle("Apple Iphones");
//        product2.setImage("IMG");
//        product2.setDescription("iphone 15 max pro");
//        product2.setCategory(category);
//        product2.setPrice(price2);
//        Product savedproduct2= productRepository.save(product2);

//
//        Optional<Category> category = categoryRepository.findById(UUID.fromString("36972903-5d6c-4e29-ba7e-45996f07eb34"));
//        if (category.isEmpty()) {
//            throw new Exception("category is null");
//        }
//        Category category1 = category.get();
//
//        List<Product> product = category1.getProducts();
//        for(Product prod:product){
//            System.out.println(prod.getTitle());
//    }
//   }
}