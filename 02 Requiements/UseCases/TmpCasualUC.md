# Use case 1: Create Order 

**Actors:**  
Consultant

**Main Succeses Scenario:**  

The application presents a form, that the Consultant user fills with the dimensions for the New Yorker wall.  
A Consultant specifies dimensions for New Yorker wall.  
The application displays a slider for number of glass panels allowed vertically.  
The application displays a slider for number of glass panels allowed horizontally.  
A Consultant specifies the number of glass panels vertically.  
A Consultant specifies the number of glass panels Horizontally.  
The application displays the dimensions of the glass panels.  
The application redirects the Consultant to Customize Order.    

**Alternate scenarios**  

The Consultant specifies Non numeric dimensions.  
The application displays a error message, prompting the consultant to use numbers.  

The Consultant specifies a height greater than the maximum value.  
The application displays a error message, prompting the consultant to use a heigth within the maximum value.  

The Consultant chooses a number of glass panels vertically, which results in a glass panel height below minimum value.  
The application displays a error message, prompting the consultant to use a glass panel amount above the minimum value. 

The Consultant chooses a number of glass panels vertically, which results in a glass panel height above maximum value.  
The application displays a error message, prompting the consultant to use a glass panel amount below the maximum value. 

The Consultant chooses a number of glass panels horizontally, which results in a glass panel width below minimum value.  
The application displays a error message, prompting the consultant to use a glass panel amount above the minimum value.  

The Consultant chooses a number of glass panels horizontally, which results in a glass panel width above maximum value.  
The application displays a error message, prompting the consultant to use a glass panel amount below the maximum value.  


# Use case 2: Customize Order

**Actors:**  
Consultant

**Main scenario:**  
The application presents the user with a template for additional components to the New Yorker wall.  
A Consultant specifies if the New Yorker wall has a door.  
&nbsp;&nbsp;&nbsp; **-** A Consultant specifies which door type the New Yorker wall has.  
&nbsp;&nbsp;&nbsp; **-** A Consultant specifies if the New Yorker wall has a Lockbox.  
&nbsp;&nbsp;&nbsp; **-** A Consultant specifies if the New Yorker wall has a handle.  
&nbsp;&nbsp;&nbsp; **-** A Consultant specifies which handle type the New Yorker wall has.  
A Consultant specifies if the New Yorker wall has special glass.  
&nbsp;&nbsp;&nbsp; **-** A Consultant specifies which special glass type the New Yorker wall has.  
A Consultant specifies if the New Yorker wall is for a Wetroom.  
A Consultant specifies if the New Yorker wall is a Shower wall.  
The application redirects the Consultant to *Preview Order*.


**Alternate scenarios**  
The Consultant chooses to not customize the order.  
The application redirects the Consultant to preview order.  

The Consultant specifies to not have a door in the New Yorker wall.  
The application makes the door handle menu aswell as the Lockbox menu unavailable.  
A Consultant specifies if the New Yorker wall has special glass.  
A Consultant specifies which special glass type the New Yorker wall has.  
A Consultant specifies not to have a Wetroom.  
A Consultant specifies not to have a Shower wall.  
The application redirects the Consultant to *Preview Order*.

The Consultant specifies to have a door in the New Yorker wall.  
A Consultant specifies the door type in the New Yorker wall to be a sliding door.  
A Consultant specifies the New Yorker wall to have a Lockbox.  
A Consultant specifies the New Yorker wall to have a handle.   
A Consultant specifies the handle to be of the type brass long grip in the New Yorker wall.   
A Consultant specifies not to have special glass in the New Yorker wall.   
A Consultant specifies not to have a Wetroom.  
A Consultant specifies not to have a Shower wall.  
The application redirects the Consultant to *Preview Order*.
