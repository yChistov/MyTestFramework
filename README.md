# MyTestFramework 
(Java + Selenide + TestNG + Allure + Selenoid)

Run test - mvn test -Dbrowser=chrome -Denvironment=local

parameters:

browser - chrome, opera, firefox. default - chrome
environment - local, docker
headless - 0 or 1. default - 0

Generate allure report - allure serve target/allure-results
