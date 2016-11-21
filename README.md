# Springboot Workbook

## Einrichtung der Umgebung
Die Umgebung für die Übersetzung und Ausführung der Beispiele kann mit Vagrant erzeugt werden. Dafür sollte Vagrant und VirtualBox installiert werden. Vagrant ist ein CLI basiertes Werkzeug zur Provisionierung und Steuerung von virtuellen Maschinen.

* [Installation Vagrant](https://www.vagrantup.com/downloads.html)
* [Installation VirtualBox](https://www.virtualbox.org/wiki/Downloads)

### Initialer Start der Umgebung
```
cd ~
mkdir demo
cd demo

wget "https://raw.githubusercontent.com/peter-dorff/springboot-workbook/master/Vagrantfile"
vagrant up
```

Mit dem ersten Start der VM mit Vagrant wird eine ''Base Box'' aus dem [HashiCorp Repository](https://atlas.hashicorp.com/boxes/search) geladen und entsprechend der Anweisungen der geladenen Datei [Vagrantfile](https://raw.githubusercontent.com/peter-dorff/springboot-workbook/master/Vagrantfile)   angepasst (provisioniert). Dieser Prozeß dauert einige Minuten. Jeder weitere Start sollte dann erheblich schneller sein. 

Nach dem Start der VM können die folgenden Kommandos ausgeführt werden.

```
vagrant ssh
cd projects
git clone https://github.com/peter-dorff/springboot-workbook.git
```

Die ausgechekten Dateien sind im Dateisystem des Host zugreifbar und editierbar.

### Ein erster Test

```
cd springboot-workbook
spring run cli/hi.groovy
```

Mit diesem Kommando wird ein Groovy basierter springboot Webservice unter Verwendung des Springboot CLI gestarted. 

```
@RestController
class GreetingRestController {
  
	@RequestMapping("/hi/{name}")
	def hi(@PathVariable String name) {
    	[greetings:"Hello "+name+"!"]
	}
}
```

Dieser Service kann im Browser des Host aufgerufen werden.  

[http://localhost:8080/hi/Peter](http://localhost:8080/hi/Peter)

und sollte das folgende Ergebnis liefern.

```
{
   greetings: "Hello Peter!"
}
```

### Stoppen der VM
```
exit
vagrant halt
```

### Starten der VM
```
cd ~/demo
vagrant up
```

## Workbook Projekte

1. [Simple Springbood CLI Demo](./hi.groovy/HI.GROOVY.md)
2. [Simple Springboot Demo](./hi.java/HI.JAVA.md) 

## Umgebung löschen

Die Umgebung für die Beispiele basiert auf einer virtuellen Maschine, welche einigen Platz auf der Festplatte belegt. Die Umgebung kann wie folgt entfernt werden.

### VM löschen
Die VM kann über das GUI der VirtualBox oder über die Komandozeile gelöscht werdern.

```
$ vagrant destroy
    default: Are you sure you want to destroy the 'default' VM? [y/N] y
==> default: Destroying VM and associated drives...
```

### Base Box löschen

Da der Download der ''Base Box'' relativ zeitaufwendig ist, wird die ''Base Box'' im HOME Verzeichnis des Benutzers für die Wiederverwendung gespeichert. 

```
$ vagrant box list
centos/7        (virtualbox, 1603.01)
ubuntu/trusty64 (virtualbox, 20160320.0.0)

$ vagrant box remove ubuntu/trusty64
Are you sure you want to remove this box? [y/N] y
Removing box 'ubuntu/trusty64' (v20160320.0.0) with provider 'virtualbox'...
```
