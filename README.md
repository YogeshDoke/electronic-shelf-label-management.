<h1 align="center">
  <a href="https://glassfish.java.net/"><img src="https://cloud.githubusercontent.com/assets/5771200/19331354/e36b95d4-9127-11e6-9a99-ce5403ea704b.jpg" alt="Oracle Glassfish" height="150"></a>
  <a href="http://www.oracle.com/technetwork/java/javaee/overview/index.html"><img src="https://cloud.githubusercontent.com/assets/5771200/19332084/330b8938-912c-11e6-8874-f992e3503bae.png" alt="Java EE" height="150"></a>
  <br>
  <br>
  Hat and Scarf
  <br>
  <br>
</h1>
<h4 align="center">A simple Java EE application to manage inventory</h4>

<p align="center">
  <a href=""><img src="https://img.shields.io/travis/feross/standard/master.svg" alt="Passing"></a>
  <a href="http://www.oracle.com/technetwork/java/javaee/overview/index.html"><img src="https://img.shields.io/badge/Java%20EE-7-brightgreen.svg" alt="Java EE"></a>
  <a href="https://opensource.org/licenses/BSD-2-Clause"><img src="https://img.shields.io/badge/License-BSD-blue.svg" alt="BSD License"></a>
</p>
<br>

## Table of Contents
- [Synopsis](#synopsis)
- [Install](#install)
- [Usage](#usage)
- [Screenshots](#screenshots)
- [License](#license)

## Synopsis
'A' company needs to build an e-business system. The system is a typical 3 - tier enterprise
application that integrates a presentation tier, a business tier, and a persistence tier. The
executive of IT Department has decided to use Java EE open source technology and related
platforms and tools to implement the system. The problem put forward was to design a very rudimentary e-commerce template to allow the company to
manage their inventory.  
 
This project required the following steps :

1. Develop a business tier using Enterprise Java Beans (EJB 3.1 or higher). The
business tier is used to process the data persistence or retrieval requests from a user and
interact with the persistence tier for accomplishing the requests.

2. Develop a presentation tier by using JavaServer Faces (JSF 2.0 or higher). The
presentation tier will provide a web-based user interface, which will allow users to
store product details, customer details and order details, and retrieve the persisted
information later on.
The program was required to use the Java Persistance API to manage the data


**Note:** To interact with the persistence tier, the EJBs must use Java Persistence Query
Language (JPQL) to query entities, and return the processed results to the presentation
tier.

## Install
First, make a directory to install the files to and change to that directory using :

```bash
 mkdir hatandscarf && cd hatandscarf
```

Then all you need to do is clone the project from github into the directory by using :

```bash
 git clone https://github.com/josh-privata/Hat_And_Scarf.git
```

## Usage
##### Note:  [Java Runtime](https://java.com/en/download/) is required to run the preceding commands.
##### Note:  [Oracle Glassfish](https://glassfish.java.net/download.html) is required to run the preceding commands.

Initially the program needs to be compiled. After you have copied the files to a directory, run the command :

```bash
$ jar cvf HatAndScarf.war .
```

Alternatively, you can use the .war file included.

Then deploy the application to Glassfish using the command :

```bash
$ asadmin deploy HatAndScarf.war
```

Or using your web browser visit [http://localhost:4848/](http://localhost:4848/) (default username/password 
is most likely admin/admin) and upload your application to the web interface.

### You can access the program by visiting [http://localhost:8080/HatAndScarf/](http://localhost:8080/HatAndScarf/)

## Screenshots

<p align="center"><img src="https://cloud.githubusercontent.com/assets/5771200/19332698/d2abd358-9131-11e6-9e91-f54e9c1202c9.jpg" width="75%" alt="Screenshot"></p>
<p align="center"><img src="https://cloud.githubusercontent.com/assets/5771200/19332664/d1a457f0-9131-11e6-90c0-6a03431bdd03.jpg" width="75%" alt="Screenshot"></p>
<p align="center"><img src="https://cloud.githubusercontent.com/assets/5771200/19332673/d1d87d50-9131-11e6-8b1b-dcf83e91fa65.jpg" width="75%" alt="Screenshot"></p>
<p align="center"><img src="https://cloud.githubusercontent.com/assets/5771200/19332697/d29795b4-9131-11e6-80b7-d25332866994.jpg" width="75%" alt="Screenshot"></p>
<p align="center"><img src="https://cloud.githubusercontent.com/assets/5771200/19332695/d2872fc6-9131-11e6-9a6d-aac9621884f2.jpg" width="75%" alt="Screenshot"></p>
<p align="center"><img src="https://cloud.githubusercontent.com/assets/5771200/19332693/d27e1d78-9131-11e6-9d87-41b7dff101c4.jpg" width="75%" alt="Screenshot"></p>
<p align="center"><img src="https://cloud.githubusercontent.com/assets/5771200/19332676/d1fd1c64-9131-11e6-8e82-2debc3d9c7f5.jpg" width="75%" alt="Screenshot"></p>
<p align="center"><img src="https://cloud.githubusercontent.com/assets/5771200/19332680/d225d230-9131-11e6-9031-4856a6658385.jpg" width="75%" alt="Screenshot"></p>
<p align="center"><img src="https://cloud.githubusercontent.com/assets/5771200/19332689/d257ef36-9131-11e6-8ed9-5e5fa39fdf59.jpg" width="75%" alt="Screenshot"></p>

## License
[BSD](LICENSE) Copyright (c) 2016 [Josh Cannons](http://joshcannons.com).
