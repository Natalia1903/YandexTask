package com.telran.testTask.test;

import com.telran.testTask.model.Item;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchItemTest extends TestBase {


    @Test
    public void  searchItemTest() {
        app.getHomePage().selectMarket();
        app.getHomePage().switchToNextTab(1);
        app.getCategory().selectDepartment("Экспресс");
        //app.getCategory().acceptCookies();
        app.getCategory().selectCatalog("elektronika/23282330");
        app.getCategory().selectCategoryType("smartfony-i-aksessuary/23282379");

        app.getItem().filterItemType(new Item().setPriceFrom("20000")
                .setPriceTo( "35000")
                .setBrand("Apple"));
        app.getItem().pause(20000);
        String itemName = app.getItem().getItemNameFromListByNamber(3);

        app.getItem().typeInSearchInputField(itemName);
        app.getItem().pause(20000);
        String foundItemName = app.getItem().getItemNameFromListByNamber(2);
        Assert.assertEquals(foundItemName,itemName);

    }

}





