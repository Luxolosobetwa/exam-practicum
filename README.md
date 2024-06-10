# exam-practicum
Luxolo sobetwa : ST10443381
https://github.com/Luxolosobetwa/exam-practicum.git

the way i see the app is that its purpose is about tracking the weather
in the app i will be creating an app that will be keeping the all the information of the weather service that has been recording during the week 
the first thing i need todo is that I have to create 3 screens the plash screen , the main screen and the detailed view sreen 
whereby in the splash screen it will be where I craete the logo and the design for the app and for the app 
then on the second screen the splash screen it will be where i sort my arrays where i will putting all the information recorded and the weather condition 
then still same screen i will calculating the avarage temperature for the week 
lastly on detailed view screen it is where i will showing of all the data that has been collected through out the week and have a button that will navigate to the main screen .

[Drawing3.pdf](https://github.com/user-attachments/files/15766388/Drawing3.pdf)

![Screenshot (1)](https://github.com/Luxolosobetwa/exam-practicum/assets/164026160/0f99918c-2962-4a88-af5b-eddcaba4bbe7)
this is the splash screen or the first screen 

![Screenshot (8)](https://github.com/Luxolosobetwa/exam-practicum/assets/164026160/dc50f64f-7282-457c-b2e6-7fd6cf209c60)
this is the Detailed view screen

![Screenshot (9)](https://github.com/Luxolosobetwa/exam-practicum/assets/164026160/f43580c5-acc5-472f-9c92-544fa455305e)
this is when you want to reinput yourdata, use new information  

![Screenshot (10)](https://github.com/Luxolosobetwa/exam-practicum/assets/164026160/f56b4328-729f-4610-bdf1-9ebb74f8dc39)
error massage that comes up when I click the button to go through to the last page 

![Screenshot (13)](https://github.com/Luxolosobetwa/exam-practicum/assets/164026160/bcb34d15-cb03-4594-b63a-82b50c7f360f)
error massage 

 psuedocode 
 
START

DISPLAY Splash Screen
  DISPLAY Name and Student Number
  WAIT for 3 seconds

NAVIGATE to Main Screen

MAIN SCREEN
  DISPLAY Weekly Weather (Days, Min Temps, Max Temps, Weather Conditions)
  DISPLAY Average Temperature
  DISPLAY Button "Next to Detailed View"

IF Button "Next to Detailed View" Clicked THEN
  NAVIGATE to Second Screen

SECOND SCREEN
  DISPLAY Editable Table (Days, Min Temps, Max Temps, Weather Conditions)
  DISPLAY Button "Clear Data"
  DISPLAY Button "Reinput Data"
  DISPLAY Button "Next to Detailed View"
  DISPLAY Average Temperature

  IF Button "Clear Data" Clicked THEN
    CLEAR Table Data
    UPDATE Table
    UPDATE Average Temperature

  IF Button "Reinput Data" Clicked THEN
    SAVE Table Data
    UPDATE Average Temperature

  IF Button "Next to Detailed View" Clicked THEN
    SAVE Table Data
    NAVIGATE to Third Screen

THIRD SCREEN
  DISPLAY Non-Editable Table (Days, Min Temps, Max Temps, Weather Conditions)
  DISPLAY Button "Back to Main Screen"

  IF Button "Back to Main Screen" Clicked THEN
    NAVIGATE to Main Screen

stop 

