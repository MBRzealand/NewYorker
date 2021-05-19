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
The application displays the dimensions of the glass panels. The application redirects the Consultant to Customize Order.  

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
