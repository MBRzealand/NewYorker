
UseCase navn | Beregning af Omsætning | 
-------------| -------------------------------| 
Scope        | Send Request
Primary Actor| Consultant
Level        | Consultant and customer goal
Beskrivelse  | The Consultant inputs height and width of the needed wall, then a guiding price is generated and is ready to send.
Stakeholders and Interests | Consultant (wishes to make the customer an offer)<br>NewYorker (potential recipient of an order)<br>Customer (The consumer who wishes to purchase a construct for their home)
Preconditions | An estimate width and height of the wall to be produced. <br> Width and height adheres to the productions limitations.
Succes Guarantee<br>(Postconditions) | A request for a wall is sent to NewYorker for production.
Main Succece Scenario |  1. Consultant defines wall height<br> 2. Consultant defines Wall width <br> 3. the application presents an offer for the wall<br> 4. Consultant makes the customer fill out contact information <br> 5. Consultant sends a production request to NewYorker and a copy to the customer.
Extensions | 1.A If the Consultant specifies a wall height greater than the defined maximum height<br><br> 1. The application displays an error message informing the Consultant of the maximum wall height.<br><br> The process continues from the 2. step.<br><br> 1.B If the Consultant specifies a wall height smaller than the defined minimum height.<br><br> 1. the application displays an error message informing the Consultant of the minimum wall height.<br><br> The process continues from the 2. step.<br><br> 1.C If the Consultant specifies a wall height with a negative value<br><br> 1. the application displaying an error message instructing the Consultant to use positive values <br><br> The process continues from the 2. step.<br><br> 1.D If the Consultant specifies a wall height with a symbol, then it will result in the application displaying an error message instructing the Consultant to use numbers.<br><br> 1. the application displays an error message instructing the Consultant to use numbers.<br><br> The process continues from the 2. step.
<br><br>If the Consultant specifies a wall width smaller than the defined minimum width, then it will result in the application displaying an error message informing the Consultant of the minimum wall width.
<br><br>If the Consultant specifies a wall width with a negative value, then it will result in the application displaying an error message instructing the Consultant to use positive values.
<br><br>If the Consultant specifies a wall width with a symbol, then it will result in the application displaying an error message instructing the Consultant to use numbers.
<br><br>If the Consultant specifies an invalid name, then the application will display an error which instructs the Consultant to rewrite the name.
<br><br>If the Consultant specifies an invalid email-address, then the application will display an error which instructs the Consultant to rewrite the email-address.<br><br>If the Consultant specifies an invalid phonenumber, then the application will display an error which instructs the Consultant to rewrite the phonenumber.<br><br>If the Consultant specifies an invalid address, then the application will display an error which instructs the Consultant to rewrite the address.
<br><br>If the Consultant specifies an invalid ZIP-code, then the application will display an error which instructs the Consultant to rewrite the ZIP-code.
Special Requirements | --
Technology & Data Variations List | Mulighed for at angive input i 1.000kr. og 1 kr.
Frequency of Occurrence | Use casene forekommer ved alle udregninger af resultat budget.
Miscellaneous | -- 
