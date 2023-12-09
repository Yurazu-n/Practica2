# Practica 2
##  __DACD -Desarollo de Aplicaciones para Ciencia de Datos__ 
==
- _Course:_ 2nd Year
- _Titulation:_ Engineering & Data Science
- _School:_ School of Informatic Engineering and Mathematics
- _College:_ ULPGC - University of Las Palmas of Gran Canaria

#
#
#
-------------

# Functionality resume 
## Prediction Provider

The code of this practice is separated beetwen 2 modules. The first one called PredictionProvider is a modified version of the code of the previous 
practice (see the code at https://github.com/Yurazu-n/Practica1_V2.git), where the class that enabled the connection to a SQLite have been replaced with one that
publish to a locally iniciated ActiveQM broker all the weather predictions information on JSON format to the topic "prediction.Weather", also giving extra information such as the time of 
the time prediction, the time when the code got the predictions (all the time are written on the UTC format) and the name of the source (in this case, since we send the
information to a broker, this parameter is going to be always "prediction-provider").
After running, the programm will be working an undefined time to get new predictions every 6 hours.


## How to use Prediction Provider

When the user runs the Main method of the Prediction Provider module the only thing needed to its proper functinallity is to provide a personal apikey to do
all the required calls to OpenWeather [5 day Weather Forecast](https://openweathermap.org/forecast5)
Once the programm is running it will start to send to the broker all the predictions obtained (5 predictions per island), informing the user when a
prediction is send

## Resources

The resources used for this module are

- IntelliJ Idea as programming environment
- Gson Library on Maven for Json treatment
- OkHttp library on Maven for Http requests
- OpenWeatherMap to get the predictions
- Concurrent Java library to do the task every 6 hours
- Git as version controler
- ActiveMQ on Maven for all the opperations with the broker
- org.slf4j on Maven for the correct functinallity of the module

# 
--------

#Functinality resume

## Event Store Builder

The second module, EventStoreBuilder, creates a connection to the broker to recieve all the predictions information and save all the events obtained 
at the same date to a .events file following the next directories organization: eventstore/prediction.Weather/{ss}/{YYYYMMDD}.events
Where "ss" is the information source (prediction-rpovider) and YYYYMMDD the date when the predictions where obtained
Just like Prediction Provider, Event Store Builder keeps running an undefined time, waiting for the next predictions to be published

## How to use Event Store Builder

The only thing needed for the Main method to run without failure is to provide the desired path to create the directories where all the events 
will be saved.

## Resources

The resources used for this module are

- IntelliJ Idea as programming environment
- Gson Library on Maven for Json treatment
- Git as version controler
- ActiveMQ on Maven for all the opperations with the broker
- org.slf4j on Maven for the correct functinallity of the module

#
--------

## Development & Design

To maintain a good level of independency beetwen all the parts of the code, each module has beeen created with the SOLID pricniples is mind
Both codes controls the exceptions with their own, abstracting part of it to the user and make them easy to substitude. They also are completely
independant to each other to make possible to change how the predictions are sent or how are they recieved.

On the design department, all the parts of the code follows the Publisher/Subscriber pattern, relating their classes like this:







 
