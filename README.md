Screenshot Service
--------------


1) Repository indirilir
2) Spring yüklü olan bir Eclipse'te "4DSightChallenge" projesi "Import existing Maven project" ile import edilir
3) Proje "clean install" goal ü ile build edilir ve "update maven project" yapılmalıdır.
4) Sprint Boot projesi çalıştırılır
5) Service endpointi = "http://localhost:8080/api/screenshot?name=urls". "urls" proje içinde bulunan file'in ismi. Bu dosya içinde screenshotı alınacak urller bulunmaktadır.
6) Serviceten dönen pathlerde alınan screenshotlar bulunmaktadır

-------------

Projede urllerin screenshotlarının alınması için Selenium Firefox Driver kullanılmıştır
Unit testte de servisin mocklanabilmesi için Mockito kullanılmıştir.
URL veya screenshotları herhangi bir databasede kaydedilmemektedir.

-----------------


Projede şuan bir database işlemi olmadığından yüksek boyutlu filelarda performance iyileştirmesi ilk olarak url dataların uygun sizeda chunklar halinde gönderilmesiyle olabilir
