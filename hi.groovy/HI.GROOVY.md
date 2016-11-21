# Simple Springboot CLI Application

Das Springboot CLI ermöglicht die Shell basierte Entwicklung von Spring Anwendungen mit Groovy. Die Shell kann einfach um eigene Kommandos erweitert werden. 

Die vollständige [Springboot CLI Dokumentaion](http://docs.spring.io/spring-boot/docs/current/reference/html/cli-using-the-cli.html)

## Kommando: spring

```
vagrant@vagrant-ubuntu-trusty-64:/vagrant/demo/cli$ spring
usage: spring [--help] [--version] 
       <command> [<args>]

Available commands are:

  run [options] <files> [--] [args]
    Run a spring groovy script

  test [options] <files> [--] [args]
    Run a spring groovy script test

  grab                
    Download a spring groovy script's dependencies to ./repository

  jar [options] <jar-name> <files>
    Create a self-contained executable jar file from a Spring Groovy script

  war [options] <war-name> <files>
    Create a self-contained executable war file from a Spring Groovy script

  install [options] <coordinates>
    Install dependencies to the lib/ext directory

  uninstall [options] <coordinates>
    Uninstall dependencies from the lib/ext directory

  init [options] [location]
    Initialize a new project using Spring Initializr (start.spring.io)

  shell                
    Start a nested shell

Common options:

  -d, --debug Verbose mode   
    Print additional status information for the command you are running

See 'spring help <command>' for more information on a specific command.
```
Zum Start des Beispiels 

```
cd /vagrant/demo/cli
spring run hi.groovy
```
Der Aufruf der URL[http://localhost:8080/hi/peter](http://localhost:8080/hi/peter) im Browser oder mit _curl_ über die Kommandozeile
```
curl "http://localhost:8080/hi/peter"
```
liefert das folgende Ergebnis:
```
{"greetings":"Hello peter!"}
```





