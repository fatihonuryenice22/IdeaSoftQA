# Idea Soft QA Case Study

## Proje Açıklaması
Bu proje, **Idea Soft QA Case Study** için oluşturulmuş bir test otomasyon projesidir. Projede **Page Object Model (POM)** kullanılarak test süreçleri düzenlenmiş ve yönetilebilir hale getirilmiştir.

## Proje İçeriği

- **Web Sitesi:** Test senaryoları, belirlenen Idea Soft web sitesi üzerinden gerçekleştirilir.
- **Ürün Seçimi:** Test senaryoları, **config.properties** dosyasından belirlenen ürün ve miktar bilgileri ile yürütülür.
- **Kod Yapısı:**
    - **`/src/main/java/pages/`** → Testlerde kullanılan sayfa metotları burada yer almaktadır.
    - **`/src/main/java/utils/`** → Test süreçlerinde kullanılan yardımcı araçlar burada bulunmaktadır.
    - **`/src/test/java/Tests/BaseTest.java`** → Her test öncesinde ve sonrasında çalıştırılması gereken **Driver açma/kapama işlemleri** burada tanımlanmıştır. Ana test sınıfımız olan **ProductSearchTest.java** ile birlikte çalışır
    - **`config.reader`** → Test Parametrelerinin ve değişkenlerinin tanımlandığı yer.
  - Loglar **`logs`** klasöründen erişilebilir
## Teknolojiler

- **Java** (Test otomasyonu dili)
- **Selenium WebDriver** (Tarayıcı otomasyonu)
- **JUnit** (Test framework)
- **Maven** (Bağımlılık yönetimi)
- **POM (Page Object Model)** yapısı
- **Logging** yapısı
---