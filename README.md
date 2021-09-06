# Andeo coding contest
This repository contains my entrance to the Andeo coding contest. It was written in TypeScript and JavaScript.

## What is the contest?
The contest is a learning-tool that teaches you english, if you're a german speaker. It gives an english sentence, and below that a german one. There is one catch to it: the german sentence has a gap, which the user is supossed to fill out. He does that by translating the sentence from english to german.

## Why TypeScript?
TypeScript is a language which is very close to JavaScript that the browser cannot run. The TypeScript file gets compiled into a Javascript file that the browser can run. Even tough I can code in JavaScript, I saw this as a perfect oppotunity to show off and improve my TypeScript abilities.

## How is this app set-up
This app has a HTML, CSS and JavaScript Frontend, with a SpringBoot backend that connects it to a PSQL DataBase, so that the users can log-in and save their correct awnsers.

## Where the sentences come from
The sentences where written by Anes Hodza and come from a database (the docker-compose file is given). Then the Database should be created and the "sentences.sql" file executed, so that the sentences exist.

## Remarks
This app was developed on a localhost server. If it is opnened as a file (by opening index.html) instead of using it as a server, CORS will reject the attempted access, because the request is not sent by either http, data, chrome, chrome-extension, brave, chrome-untrusted or https. To fix this issue, simply open it as a localhost server. This can be achieved trought for example VSCodes "live server" extention or trough python3's ```python -m http.server 5500``` command.

## How this repo is set up
This Repo has two main folders, frontend and backend. The backend contains two sub-folders, one named SourceCode, and another one named Deployable. The frontend folder contains src and public.
### Backend
The Deployable folder contains the compiled and .jar files, which can be run by typing ```java -jar backend-0.0.1-SNAPSHOT.jar```. The sourcecode folder contains the .java files. This folder can theoretically be ignored.
### Frontend
The frontend contains a src folder, which contains the .ts files. This folder can theoretically be ignored. The public folder on the other hand contains all the .js, .html and .css files.