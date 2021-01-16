## Make Change Project
<img src = "https://creazilla-store.fra1.digitaloceanspaces.com/cliparts/25396/1548373463-clipart-md.png" />

### Description
In the cash register we will calculate the amount of change returned to a customer based on the purchase price and the amount tendered. We will also notify the attendant how many of each piece of currency ($20 ,$10 ,$5 ,$1, .25c, .10c, .05c, .01c) is needed to make the change for the customer. Change should be provided using the largest bill and coin denominations as possible. Denominations that are not used should not be displayed.


### Topics and Technologies Used
* Conditionals (**if / else**) - If / Else statements were used to check if exact or insufficient amounts were tendered before it ran the method to get the change amount. If statements were used within the get change method to only add denominations to the change needed amounts when appropriate.
* Looping (**for, while,** and **switch**) - While loops were used to calculcate how many one dollar bills were needed for change when appropriate. A for loop was used in combination with switch to create a method to run all four of the test cases.

### How to Run
Run the application. If you want to run the application with the test cases, uncomment the test cases method at the beginning of the main block.

### Lessons Learned
It is important to check for assumptions with rounding when converting between data types. For the penny value within the project, I was loosing a penny within the program for two of my test cases. In order to identify where this was happening I printed the double value and the integar value for all my test cases and noticed that I had programmed in a logic error. I had forgotted to account for the Java program truncating the decimals rather than rounding. To fix this I added 0.005 to my double before the conversion. This solved the discrepancies between the expected and the output within the test cases.