# personal_budget
A personal finance tool. It can track your monthly and annual expenditure. Gives you useful reports about your shortfalls, your spending habits, strong and weak points.


# For Developers

### Contributing:
Any contributions are welcome.


### Prerequisites:
```
You must have npm and nodejs installed (latgest versions). Make sure you have the latest version of @angular/cli (supporting angular 6).

npm install npm@latest -g

Should you wish to build and package a .WAR artifact for deployment into an external tomcat container, make sure you have rimraf, copyfiles and mkdirp installed on your system : 

npm install -g rimraf
npm install -g mkdirp
npm install copyfiles -g


```

### Build:
```
When ready to deploy the SPRING-BOOT java project along with ANGULAR FRONT-END contents, just follow this procedure :

In the angular project directory (directory containing the package.json file), run :

npm run build

Your spring boot resources/static and /webapp directories will now have have the latest compiled angular resources.
then in your maven project directory, run :

mvn clean package

done ! you have a deployable artifact ready to be deployed in a web container.
```