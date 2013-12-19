![screenshot](https://raw.github.com/aghalarp/surferpedia/dynamic/doc/surferpedia-docs-homepage.png)

![screenshot](https://raw.github.com/aghalarp/surferpedia/dynamic/doc/surferpedia-docs-newsurfer.png)

![screenshot](https://raw.github.com/aghalarp/surferpedia/dynamic/doc/surferpedia-docs-surferpage.png)

![screenshot](https://raw.github.com/aghalarp/surferpedia/dynamic/doc/surferpedia-docs-editsurfer.png)

Overview
--------

A [Play Application](http://www.playframework.com/) that provides an encyclopedia of surfers.

Installation
------------

Download the zip file, unzip, cd into the directory, invoke the Play console, and execute the run command to see the application at http://localhost:9000

You need to setup the admin credentials in your environment variables. The variables are `SURFERPEDIA_ADMIN_EMAIL` and `SURFERPEDIA_ADMIN_PASSWORD`.

You need to setup a database to use with the application. You can install MySQL from the [website](http://dev.mysql.com/downloads/mysql/) and setup the following environment variables:
- DATABASE_URL_DB
- DATABASE_USERNAME_DB
- DATABASE_PASSWORD_DB

Usage
-----

Use the navbar to find interior pages with bio information on surfers.
To add new surfers, click on the "New" button and fill out the form with information on the surfer.
To edit existings surfers, go to the surfer's biography page and click the "Edit" button on the bottom left. You can
also delete a surfer here by clicking the "Delete" button on the bottom right of the page.
Create an account and add surfers to your favorites list.

ER Diagram
----------
![ERD](https://raw.github.com/aghalarp/surferpedia/master/doc/surferpedia-docs-erd.png)

Click [here](https://drive.google.com/file/d/0B8m7CP-fAjuDSXBET0JhbjhHQ00/edit?usp=sharing) to view/edit the ERD (collaborators only).

Credits
-------

Thanks to ICS 314, Fall 2013 for support
  


