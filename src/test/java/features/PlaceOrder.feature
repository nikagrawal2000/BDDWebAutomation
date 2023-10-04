@UI
Feature: Place order 


Background: Customer launch application
Given Customer Launches Application

@newUserPlaceOrderBySearchingCategoryProduct
Scenario: Place Order by new SignIn and searching product by category 
	When Customer select product by Women Category 
	And Customer Add his preferred product "Printed Dress" Category 
	And Customer Add selected product to cart 
	And Customer Continue to Shopping 
	And Customer select product by Dresses Category 
	And Customer Add his preferred product "Printed Summer Dress" Category 
	And Customer Add selected product to cart 
	And Customer proceeds for checkout
	And Customer Proceeds to checkout on Summary Page
	And Customer enter email "nik.agrawal@test.au" for creating account 
	And Customer Create his account 
	And Customer select his gender "Male" 
	And Customer enter his firstname "TestName" 
	And Customer enter his lastname "TestSurname" 
	And Customer enter his password "XXXXX@123" 
	And Customer enter his DateOfBirth "2 2 1992" 
	And Customer enter his company "WooliesX" 
	And Customer enter his address "10 Rex street" 
	And Customer enter his city "Sydney" 
	And Customer enter his state "Maine" 
	And Customer enter his postcode "00000" 
	And Customer select his country "United States" 
	And Customer enter additional information "Register me" 
	And Customer enter mobile no "0469872035" 
	And Customer registered himself 
	And Custome selects "My address" 
	And Customer Proceeds to checkout on Address Page 
	And Customer Agrees terms on Shipping Page 
	And Customer Proceeds to checkout on Shipping Page 
	And Customer select payment option "Pay by bank wire" 
	And Customer confirm his order 
	Then Customer should get success message "Your order on My Store is complete." 

@existingUserPlaceOrderBySearchingPopularProducts
Scenario: Place Order by Existing Logon and searching by popular products 
	When Customer click on popular products 
	And Customer Add popular product "Faded Short Sleeve T-shirts" 
	And Customer Continue to Shopping 
	Then Customer Add popular product "Printed Dress" 
	And Customer proceeds for checkout 
	And Customer Proceeds to checkout on Summary Page 
	And Customer SingIn by giving his credentials 
	And Custome selects "My address" 
	And Customer Proceeds to checkout on Address Page 
	And Customer Agrees terms on Shipping Page 
	And Customer Proceeds to checkout on Shipping Page 
	And Customer select payment option "Pay by bank wire" 
	And Customer confirm his order 
	Then Customer should get success message "Your order on My Store is complete."

@existingUserChecksTotalOfProducts
Scenario: Place Order by Existing Logon and searching by Best Sellers 
	When Customer click on Best Sellers 
	And Customer Add his preferred product "Printed Chiffon Dress" 
	And Customer Continue to Shopping 
	And Customer Add his preferred product "Faded Short Sleeve T-shirts"
	And Customer Continue to Shopping 
	And Customer Add his preferred product "Printed Summer Dress"  
	And Customer proceeds for checkout 
	Then Checks Total value
	And Customer Deletes one product
	Then Checks Total value
	And Customer Proceeds to checkout on Summary Page 
	And Customer SingIn by giving his credentials 
	And Custome selects "My address" 
	And Customer Proceeds to checkout on Address Page 
	And Customer Agrees terms on Shipping Page 
	And Customer Proceeds to checkout on Shipping Page 
	And Customer select payment option "Pay by bank wire" 
	And Customer confirm his order 
	Then Customer should get success message "Your order on My Store is complete."
	And Quits the browser
	
	
	
	
 
	
	
	
