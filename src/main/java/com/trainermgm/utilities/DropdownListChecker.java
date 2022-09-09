package com.trainermgm.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class DropdownListChecker {
	
	public static Boolean getMultiListStatus(WebDriver driver, List<WebElement> eleList, WebElement eleBtn, String[] expEleList) throws InterruptedException
	{
		int counter = 0;
		Boolean listStatus = true;
		int actLen = eleList.size();
		int expLen = expEleList.length;
		if(actLen == expLen)
		{
			eleBtn.click();
			PageScroller.scrollIntoView(driver, eleBtn);
			for(String str: expEleList)
			{
				for(int i=0;i<eleList.size();i++)
				{
					System.out.println("Looking at:"+str+ "and Comparing with: "+eleList.get(i).getText());
					if(str.equals(eleList.get(i).getText()))
					{
						counter = counter+1;
					}
				}
			}
			if(counter != expLen)
			{
				listStatus = false;
			}
		} else listStatus = false;
		
		return listStatus;
	}
	
	
	public static Boolean getListStatus(WebDriver driver, WebElement dropdownEle, String[] expEleList) throws InterruptedException
	{
		int counter=0;
		int expListLen = expEleList.length;
		Select eType = new Select(dropdownEle);
		ArrayList<String> actList =  new ArrayList<String>();
		List<WebElement> options = eType.getOptions();
		for(WebElement option: options)
		{
		actList.add(option.getText());
		}
		for(String actType: actList)
		{
			for(String expType: expEleList)
			{
				System.out.println("Checking act Type: "+actType+ " with exp Type: "+expType);
				if(actType.equals(expType))
				{

				counter = counter + 1;
				}
			}
		}
		if(counter == expListLen)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
