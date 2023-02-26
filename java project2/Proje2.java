package Proje_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

    public class Proje2 {

        public static void main(String[] args) {

            // Scanner Class tanimlayin...
            Scanner oku = new Scanner(System.in);

            // Banka Islemleri Listesi tanimlayin..."Para_Yatir", "Para_Cek", "Transfer", "Hesap_Ac"...

            List<String> actions = new ArrayList<>(Arrays.asList("Para Yatırmak İçin", "Para Çekmek İçin", "Transfer İşlemleri İçin", "Çıkış Yapmak İçin"));

            // Banka musterileri kullanici adi listesi tanimlayin..."User1", "User2", "User3"...
            ArrayList<String> users = new ArrayList<>(Arrays.asList("User1", "User2", "User3"));

            // Banka musterileri sifreleri listesi tanimlayin..."password1", "password2", "password3"...
            ArrayList<String> passwords = new ArrayList<>(Arrays.asList("pw1", "password2", "password3"));

            // Banka musterilerine ait banka hesap numaralari listesi tanimlayin.."1234", "5678", "9999"
            List<String> accounts = new ArrayList<>(Arrays.asList("1234", "5678", "9999"));

            // Banka musterilerine ait banka hesaplarinda bulunan para miktarlarini tanimlayin...200, 1000, 5000
            List<Integer> funds = new ArrayList<>(Arrays.asList(200, 1000, 5000));


            while (true) {

                //Sonsuz bir dongu icerisinde kullanicidan username ve password girmesini isteyelim...
                System.out.print("Kullanıcı Adı Giriniz: ");
                String user = oku.next();
                System.out.print("Şifre Giriniz: ");
                String password = oku.next();
                //Konsoldan girilen username ve passwordu confirmUsernameAndPassword() methodunu cagirarak teyit edelim..

                confirmUsernameAndPassword(users, user);
                int correctPswIndex;
                String correctPsw = null;
                if (users.contains(user)) {
                    correctPswIndex = users.indexOf(user);//girilen username listede kayıtlı ise username'in arraylistdeki index numarasını değişkene kaydeder.
                    correctPsw = passwords.get(correctPswIndex);//username indexine karşılık gelen passwordu correctPsw değişkenine atar.
                }

                if (users.contains(user) && !password.equals(correctPsw)) {//correctPsw ile kullanıcı tarafından girilen password birbirine eşit değil ise yanlış şifre hatasını verir. Tekrar sorgu sağlar.
                    System.out.println("Yanlış Şifre Girdiniz Tekrar Deneyiniz.");
                } else if ((users.contains(user) && password.equals(correctPsw))) {        //correctPsw ile kullanıcı tarafından girilen password birbirine eşit ise sisteme giriş yapar döngüden çıkar
                    System.out.println("Sisteme Başarılı Şekilde Giriş Yaptınız.");
                    break;
                }

                //Eger dogru username ve password girilmis ise "Basarili bir sekilde giris yaptiniz" mesaji yazdirarak yapmak istedigi islemi soralim ...
                //Kayitli olmayan username ve password girilmis ise "Sistemde kayitli boyle bir kullanici bulunamadi.. Tekrar deneyin" mesaji
                //gosterip kullaniciyi tekrar username ve password girisine geri dondurelim..

            }

            while (true) {
                System.out.println("Yapmak İstediğiniz İşlem Numarasını Tuşlayınız...");
                for (int i = 0; i < actions.size(); i++) {
                    System.out.println(actions.get(i) + " - " + (i + 1));//seçenekleri yazdır
                }
                String userChoice = oku.next();//string olarak yeniden tanımlandı ve farklı seçim hatası giderildi

                switch (userChoice) {
                    case "1": {
                        System.out.println("Bu Bankamatik Geçici Olarak Para Yatırma İşlemine Kapalıdır...");
                        break;

                    }
                    case "2": {
                        System.out.println("Hangi Hesaptan Para Çekmek İstiyorsunuz?");
                        int sira = 1;
                        int fundSira = 0;
                        for (String account : accounts) {
                            System.out.println(sira + ". Hesap No: " + account + " Bakiye: " + funds.get(fundSira));//hesap numaralarını yazdır
                            sira++;
                            fundSira++;
                        }
                        System.out.print("\n" + "Çekim Yapmak İstediğiniz Hesap Numarası: ");
                        String chosenAccount = oku.next();
                        if (accounts.contains(chosenAccount)) {
                            System.out.print("Çekmek İstediğiniz Tutarı Giriniz: ");
                            int amountToWithdraw = oku.nextInt();
                            withdraw(accounts, funds, chosenAccount, amountToWithdraw);
                        } else
                            System.out.println("Hatalı Hesap Numarası Tuşladınız.. Lütfen Tekrar Deneyiniz.");
                        break;

                    }
                    case "3": {
                        System.out.println("Bu İşlemi Şu An Gerçekleştiremiyoruz...");
                        break;
                    }
                    case "4":
                        System.out.println("Çıkış Yapıldı.");
                        System.exit(1);
                    default: {
                        System.out.println("Başarılı Bir Seçim Yapmadınız..." + "\n" + "Lütfen Tekrar Deneyiniz.");
                        break;
                    }
                }

            }


//         Secim hatali ise "Basarili bir secim yapmadiniz..." ikazi vererek tekrar secim yapmasini isteyelim..
//         Dogru bir secim yapildiginda kullanici tarafindan secilen islem SWITCH Statements vasitasiyla koda aktarilsin
//         Case 1: "Bu bankamatik gecici olarak para yatirma islemine kapalidir...Uzgunuz" ikazi versin..
//         Case 2: "Hangi hesaptan para cekmek istiyorsunuz?" diye kullaniciya sorsun
//                  Hesap numaralarini yukaridaki List ten alarak ekrana yazdirin.. Kullanici sectigi hesap numarasini tuslasin..
//                 "Ne kadar para cekmek istiyorsunuz?" diye soralim..Kullanici girdisini alalim...
//                  asagida bulunan withdraw() methodunu cagirarak hesaptan para cekme islemini tamamlayalim...
//                  tekrar islemler dongusune geri donelim...
//         Case 3: "Bu islemi su an gerceklestiremiyoruz..." diyerek basa donsun..
//         Case 4:  System.exit(1);  buradaki kodu case 4 e aynen kopyalayip yapistirin...
//         default:"Basarili bir secim yapmadiniz..." mesaji versin..


        }

        private static void withdraw(List<String> accounts, List<Integer> funds, String chosenAccount, int amountToWithdraw) {
            Scanner okuStr = new Scanner(System.in);

            // Bu method parametre olarak aldigi accounts (hesaplar) ve funds (hesapta bulunan para miktarlari) listelerinde bulunan degerleri
            // kullanici tarafindan girilen degerler ile birlikte kullanabilmek icin olusturulmusutur...
            int accIndex;
            int fundIndex;
            int kalanMik;
            if (accounts.contains(chosenAccount)) {
                accIndex = accounts.indexOf(chosenAccount);
                fundIndex = accIndex;
                kalanMik = funds.get(fundIndex) - amountToWithdraw;

                if ((kalanMik < 0)) {

                    System.out.println("Bu Hesabınızda Yeterli Miktarda Bakiye Bulunmamaktadır." + "\n" + "Eksi Bakiyeden Çekim Yapmak İster Misiniz? (E/H)");
                    String tercih = okuStr.next();

                    switch (tercih.toUpperCase()) {
                        case "E": {

                            System.out.println("Eksi Hesap Kullanımı Hesabınıza Tanımlandı. Tutar Eksi Hesabınızdan Tahsil Edildi");
                            funds.set(fundIndex, kalanMik);
                            System.out.println("Çekim Yapılan Hesap İçin Mevcut Bakiyeniz: " + funds.get(fundIndex) + "₺");
                            break;                    }

                        case "H": {

                            System.out.println("Eksi Hesap Kullanım Tercihiniz Kaydedildi.");
                            break;                    }

                        default: {
                            System.out.println("Hatalı Tercih Yaptınız.");
                        }

                    }
                }

                if ((kalanMik >= 0)){
                    System.out.println("Çekim İşleminiz Başarıyla Gerçekleşti, Hesabınızda Kalan Miktar: " + kalanMik + "₺");
                    funds.set(fundIndex, kalanMik);}

                if (!accounts.contains(chosenAccount))
                    System.out.println("Hatalı Hesap Seçimi Yaptınız.");



                // Eger kullanici hesap numarasini yanlis girmisse veya hesabinda bulunan para miktari yeterli degilse
                // "Beklenmedik bir hata olustu...Iyi gunler dileriz..." ikazi vermelidir...
            }}

        private static void confirmUsernameAndPassword (ArrayList < String > users, String username){
            //Kullanici yukarida olusturdugumuz kullanici adi ve password lerden birini girmez ise bu method FALSE dondurmelidir..

            if (!users.contains(username))
                System.out.println("Sistemde Kayıtlı Böyle Bir Kullanıcı Bulunamadı... Tekrar deneyin");
        }
    }


/*
Geliştirmeler:
1- Hesaptan para çekimi yapıldıktan sonra tekrar çekim yapıldığında önceki çekimi yoksayan hata giderilerek kalan tutarın liste üzerinden güncellenmesi fonksiyonu eklendi.
2- Güncel bakiyelerin hesaplar ekranında iligili hesap numara yanlarında görüntülenmesi fonksiyonu eklendi.
3- Hesapta bulunan paradan fazlası çekilmek istendiğinde "Bu Hesabınızda Yeterli Miktarda Bakiye Bulunmamaktadır. Eksi Bakiyeden Çekim Yapmak İster Misiniz? (E/H)" mesajı verme ve kullanıcıdan tercih alarak çekim gerçekleşirse kalan tutarı bildirme fonskiyonları eklendi.
4- Hatalı eksi hesap tercih seçimi ya da  hatalı banka hesabı seçimi yapıldığı durumda, ilgili uyarı mesajı gösterilerek tekrar seçim ekranına döndürme fonksiyonu eklendi.
5- Users ve passwords listelerinde var olan fakat eşleşmeyen iki veri girildiğinde ortaya çıkan hatalar giderildi.
6- Kullanıcı doğru olduğu halde hatalı şifre girildiğinde  "Yanlış Şifre Girdiniz Tekrar Deneyiniz." mesajını verip tekrar sorgu yapan fonskiyon eklendi.
7- Kullanıcı action seçim ekranında sayı harici giriş yapıldığında karşılaşılan buglar giderilerek ilgili hata mesajı gösterilip doğru seçim yapması için tekrar sorgu döngüsüne yönlendirildi.
 */

