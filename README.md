# JAVA YAZILIM GELİŞTİRME UZMANI – ADAY DEĞERLENDİRME PROJE ÖDEVİ

<img width="100%" alt="ekran görüntüsü" src="https://github.com/user-attachments/assets/70da4f7f-1931-472f-bfba-cbc81b2d9b77" />


## 
Bu proje, **Fonet Bilgi Teknolojileri A.Ş.** tarafından Java Yazılım Geliştirme Uzmanı adaylarını değerlendirmek amacıyla verilen bir emlak yönetim sistemi, Java ile ‘Emlak İşletmeleri’ proje örneğidir. Kullanıcı dostu bir arayüz ile, emlak ofislerinin işletme, müşteri ve emlak yönetimini dijital olarak gerçekleştirmesi hedeflenmiştir. Kiralık veya satılık daireleri arayabilme, uygun eşleşmeleri listeleme ve yazdırılabilir emlak bilgileri gibi işlevler bu sistem aracılığıyla sunulmuştur. Hem işletmeler hem de bireysel müşteriler için süreçlerin kolaylaştırılması hedeflenmiştir.Proje dosyaları içinde tüm kodlar açık bir şekilde sunulmuş , uygulamanın testi açıklayıcı bir video ile anlatılmıştır, mp4 kayıt dosyasına erişip uygulamanın kullanım videosunu indirerek izleyebilirsiniz (yaklaşık 1.5 dakika olduğu için ön izleme yapılamıyor).

##  Veritabanı Şeması

Uygulama,  temelde üç tablo üzerinde şekillenmektedir: `emlak`, `musteri` ve `isletme`. Bu tablolar birbiriyle ilişkili olarak çalışmakta ve emlak yönetim süreçlerini modellemektedir. Aşağıda hem tablo yapıları hem de ilişkiler aşağıda görsellerle açıklanmıştır.

---

###  Emlak Tablosu (`emlak`)

Bu tablo, sisteme kayıtlı tüm emlakları (kiralık veya satılık) temsil eder. Her emlak, bir müşteriye (sahibi) ve bir işletmeye (aracılık eden emlak ofisi) bağlıdır.

**Alanlar:**
- `id`: Emlak kaydının kimliği 
- `musteri_id`: Emlak sahibinin müşteri tablosundaki ID’si 
- `tur`: Kiralık veya satılık bilgisi
- `metrekare`, `oda_sayisi`, `kat`, `bina_kati`: Fiziksel özellikler
- `isinma`: Isınma türü (Doğalgaz, kömür vs.)
- `durum`: Kaydın durumu (örneğin: aktif, pasif)
- `isletme_id`: Bu kaydı yöneten işletmenin ID’si

📷 Görsel:
<img width="1090" height="275" alt="Emlak Tablosu" src="https://github.com/user-attachments/assets/c9eb41c8-6848-472e-8045-1ce82199c6bb" />

---

###  İşletme Tablosu (`isletme`)

Emlak ofislerine ait bilgiler bu tabloda tutulur. Her müşteri ve her emlak kaydı bir işletmeye bağlı olabilir.

**Alanlar:**
- `id`: İşletmenin kimliği
- `ad`: İşletme adı
- `yetkili`: İşletme sahibinin/temsilcisinin adı
- `adres`, `telefon`, `fax`: İletişim bilgileri

📷 Görsel:
<img width="934" height="214" alt="İşletme Tablosu" src="https://github.com/user-attachments/assets/5e78cf2c-f29b-4d75-b8a9-d2f6a6f83913" />

---

###  Müşteri Tablosu (`musteri`)

Emlak alım, satım veya kiralama işlemlerine dahil olan kişilere ait bilgiler bu tabloda tutulur. Her müşteri bir işletmeye bağlıdır.

**Alanlar:**
- `id`: Müşterinin kimliği 
- `ad`, `soyad`: Müşteri adı ve soyadı
- `ev_tel`, `cep_tel`: Telefon numaraları
- `email`: E-posta adresi
- `isletme_id`: Müşterinin bağlı olduğu işletme

📷 Görsel:
<img width="1066" height="352" alt="Müşteri Tablosu" src="https://github.com/user-attachments/assets/b633e949-108e-4cb3-a641-97e60abaf1bf" />

---


Bu yapılar sayesinde her emlak bir müşteriye ve bir işletmeye bağlı, her müşteri ise bir işletme altında yönetilebilmektedir. Bu da sistemi "birey–ev sahibi–emlak" üçgeni etrafında organize etmektedir.



##  Uygulama Özeti

Uygulama; işletmelerin, müşterilerin ve emlak kayıtlarının yönetilebildiği, aynı zamanda müşterilerin kriterlerine göre uygun kiralık veya satılık dairelerin arandığı bir web sistemidir. Kullanıcılar yeni işletmeler ve müşteriler ekleyebilir, bu müşterilere bağlı emlak kayıtları oluşturabilir. Arama talepleri ile metrekare, oda sayısı ve ısınma türü gibi kriterlere göre filtreleme yapılabilir. Uygun bulunan emlaklar liste halinde gösterilir ve yazdırılabilir çıktı olarak alınabilir.

## Teknik Yapı

Proje, `Spring Boot` kullanılarak geliştirilen bir Java backend ile birlikte, sade ve responsif yapıya sahip `HTML5 / CSS3 / JavaScript` tabanlı bir frontend yapısı içerir. 

### Backend
- Katmanlı mimari: "mode"`, "repository", "service", "controller"
- RESTful API tasarımı
- JPA ile veritabanı işlemleri
- PostgreSQL

### Frontend
- Saf HTML/CSS/JS ile yazılmıştır
- Feather Icons ve Google Fonts (Poppins) ile modern görünüm sağlanmıştır
- Karanlık tema, responsive tasarım uygulanmıştır
- Tüm işlemler API ile doğrudan entegrasyon sağlanmıştır
- Kullanıcılar için kolay erişilebilir butonlar ve listeleme panelleri eklenmiştir

### 📌 Dipnot

Proje boyunca kullanılan class , variable ve veritabanı alan adları **normal şartlarda İngilizce tercih etsem de**, bu projede **aday değerlendirme dokümanının Türkçe olması ve içerikte net bir şekilde Türkçe kavramlara yer verilmesi** sebebiyle özellikle **Türkçe terimler tercih ettim**.

Projelerimde genellikle İngilizce isimlendirme tercih etmekteyim , değerlendirme kriterinizin etkilenmemesi adına not düşmek istedim.

---

