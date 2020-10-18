package com.nobrokerserach.test;

import java.awt.AWTException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import General.BaseClass;
import Pages.Homepage;

public class HomepageSearch extends BaseClass {
	@Test(priority=1,dataProvider = "NobrokerSearch_Data")
	public void search(String  choice_place_one,String choice_place_second,String flat_size,String flat_size_2nd_option,String item_number) throws InterruptedException, AWTException
	{
		Homepage Hp=PageFactory.initElements(driver,Homepage.class);
		Hp.select_location(choice_place_one);
		Hp.select_location(choice_place_second);
		Hp.select_flat_type(flat_size);
		Hp.select_flat_type(flat_size_2nd_option);
		Hp.btn_search_item.click();
		Hp.searchitem(item_number);
	}
	
	
	@DataProvider(name="NobrokerSearch_Data")
	public Object[][] getDataFromDataprovider(){
	    return new Object[][] 
	    	{
	            { "MaladEast-Malkani Estate", "Malad west-Sundar Ln","bhk2","bhk3","4" }
	        };

}
}
