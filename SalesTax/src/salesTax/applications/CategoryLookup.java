package salesTax.applications;
import java.util.HashMap;

import salesTax.applications.constants.Constants;

public class CategoryLookup {

        private static CategoryLookup instance;
        private static HashMap<String, String> itemCategoriesMap;

        public static CategoryLookup getInstance() {
                if (instance == null) {
                        instance = new CategoryLookup();
                }
                return instance;
        }

        private CategoryLookup() {
                itemCategoriesMap = new HashMap<String, String>();
                itemCategoriesMap.put("book", Constants.BOOKS);
                itemCategoriesMap.put("books", Constants.BOOKS);
                itemCategoriesMap.put("chocolate", Constants.FOOD_PRODUCT);
                itemCategoriesMap.put("chocolates", Constants.FOOD_PRODUCT);
                itemCategoriesMap.put("music", Constants.OTHER);
                itemCategoriesMap.put("perfume", Constants.OTHER);
                itemCategoriesMap.put("pills", Constants.MEDICAL_PRODUCT);

        }
      //Adding product information to cache lookup
        public void addProductToLookUp(String item, String category) {
                itemCategoriesMap.put(item, category);
        }

        //Remove product information from cache lookup
        public void removeProductFromLookUp(String productName) {
                if (itemCategoriesMap.containsKey(productName))
                        itemCategoriesMap.remove(productName);
        }

        //Getting category Name for given product description
        public String getCategoryFor(String productDescription) {
                String[] productKeyWords = productDescription.split(" ");
                String category = Constants.OTHER;
                for (int keyWordIndex = 0; keyWordIndex < productKeyWords.length; keyWordIndex++) {
                        if (itemCategoriesMap.containsKey(productKeyWords[keyWordIndex])) {
                                category = itemCategoriesMap.get(productKeyWords[keyWordIndex]);
                        }
                }
                return category;
        }

}