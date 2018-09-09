Screenshot Service
--------------


1) Repository indirilir
2) Screenshotların alınabilmesi için bilgisayarda (Eğer windows kullanıyorsanız) C'nin altına "\SeleniumGecko" adında bir dosya yaratılıp, daha sonra "https://github.com/mozilla/geckodriver/releases" linkindeki "geckodriver-v0.21.0-win64.zip" dosyası indirilerek içerideki geckodriver.exe "C:\SeleniumGecko" directorysine kopyalanır. 
3) Spring yüklü olan bir Eclipse'te "4DSightChallenge" projesi "Import existing Maven project" ile import edilir
4) Proje "clean install" goal ü ile build edilir ve "update maven project" yapılmalıdır.
5) Sprint Boot projesi çalıştırılır
6) Service endpointi = "http://localhost:8080/api/screenshot?name=urls". "urls" proje içinde bulunan file'in ismi. Bu dosya içinde screenshotı alınacak urller bulunmaktadır. File isteğ göre güncellenebilir.
7) Serviceten dönen pathlerde alınan screenshotlar bulunmaktadır

-------------

Projede urllerin screenshotlarının alınması için Selenium Firefox Driver kullanılmıştır
Unit testte de servisin mocklanabilmesi için Mockito kullanılmıştir.
URL veya screenshotları herhangi bir databasede kaydedilmemektedir.

-----------------


Projede şuan bir database işlemi olmadığından yüksek boyutlu filelarda scalebility ilk olarak url dataların uygun sizeda chunklar halinde gönderilmesiyle olabilir
